import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db", "root", "Leoleoleo123");

            String query = "DELETE FROM bank_accounts WHERE accountNumber=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accountNumber);
            ps.executeUpdate();

            response.sendRedirect("bankSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
