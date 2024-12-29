import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MarksInsertServlet")
public class MarksInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/assignment_db";
    private static final String USER = "root";
    private static final String PWD = "Leoleoleo123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String usn = request.getParameter("usn");
        String name = request.getParameter("name");
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");
        String s3 = request.getParameter("s3");
        String s4 = request.getParameter("s4");
        String s5 = request.getParameter("s5");
        String s6 = request.getParameter("s6");

        // Initialize marks and results
        int mark1 = 0, mark2 = 0, mark3 = 0, mark4 = 0, mark5 = 0, mark6 = 0;
        int total = 0;
        double percentage = 0.0;
        String grade = "";
        String status = "";

        // Validate and parse the input
        try {
            // Parse marks
            mark1 = Integer.parseInt(s1);
            mark2 = Integer.parseInt(s2);
            mark3 = Integer.parseInt(s3);
            mark4 = Integer.parseInt(s4);
            mark5 = Integer.parseInt(s5);
            mark6 = Integer.parseInt(s6);

            // Calculate total and percentage
            total = mark1 + mark2 + mark3 + mark4 + mark5 + mark6;
            percentage = ((double) total / 600) * 100;

            // Determine grade and status based on percentage
            if (percentage >= 91 && percentage <= 100) {
                grade = "A1";
                status = "Pass";
            } else if (percentage >= 81 && percentage < 91) {
                grade = "A2";
                status = "Pass";
            } else if (percentage >= 71 && percentage < 81) {
                grade = "B1";
                status = "Pass";
            } else if (percentage >= 61 && percentage < 71) {
                grade = "B2";
                status = "Pass";
            } else if (percentage >= 51 && percentage < 61) {
                grade = "C1";
                status = "Pass";
            } else if (percentage >= 41 && percentage < 51) {
                grade = "C2";
                status = "Pass";
            } else {
                grade = "D";
                status = "Fail";
            }

            if (status.equals("Pass")) {
                // Insert into database
                insertStudent(usn, name, mark1, mark2, mark3, mark4, mark5, mark6, total, percentage, grade, status);
                // Redirect to success page or confirmation
                response.sendRedirect("success.jsp");
            } else {
                // Redirect to failure page or show message
                response.sendRedirect("fail.jsp");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Redirect to an error page or show error message
            response.sendRedirect("error.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Redirect to an error page or show error message
            response.sendRedirect("error.jsp");
        }
    }

    private void insertStudent(String usn, String name, int s1, int s2, int s3, int s4, int s5, int s6, int total, double percentage, String grade, String status) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO students (usn, name, research_methodology, dsa, mathematics, operating_system_unix, software_engineering, computer_networks, total_marks, percentage, grade, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(URL, USER, PWD);
             PreparedStatement psmt = con.prepareStatement(query)) {

            psmt.setString(1, usn);
            psmt.setString(2, name);
            psmt.setInt(3, s1);
            psmt.setInt(4, s2);
            psmt.setInt(5, s3);
            psmt.setInt(6, s4);
            psmt.setInt(7, s5);
            psmt.setInt(8, s6);
            psmt.setInt(9, total);
            psmt.setDouble(10, percentage);
            psmt.setString(11, grade);
            psmt.setString(12, status);

            psmt.executeUpdate();
        }
    }
}
