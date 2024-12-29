import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        double newBalance = Double.parseDouble(request.getParameter("newBalance"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db", "root", "Leoleoleo123");

            String query = "UPDATE bank_accounts SET balance=? WHERE accountNumber=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, newBalance);
            ps.setString(2, accountNumber);
            ps.executeUpdate();

            response.sendRedirect("bankSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
