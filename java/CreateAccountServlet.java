import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String accountHolder = request.getParameter("accountHolder");
        double balance = Double.parseDouble(request.getParameter("balance"));

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db", "root", "Leoleoleo123");

            // Insert account details
            String query = "INSERT INTO bank_accounts (accountNumber, accountHolder, balance) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accountNumber);
            ps.setString(2, accountHolder);
            ps.setDouble(3, balance);
            ps.executeUpdate();

            response.sendRedirect("bankSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
