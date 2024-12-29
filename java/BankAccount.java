import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BankAccount")
public class BankAccount extends HttpServlet {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Default constructor
    public BankAccount() {
        super();
    }

    // Constructor with parameters
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Handling GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Example of processing and responding with some account information
        response.setContentType("text/html");
        response.getWriter().println("<h1>Bank Account Details</h1>");
        response.getWriter().println("<p>Account Number: " + accountNumber + "</p>");
        response.getWriter().println("<p>Account Holder: " + accountHolder + "</p>");
        response.getWriter().println("<p>Balance: $" + balance + "</p>");
    }

    // Handling POST request (if you want to allow modifications, e.g., updating the balance)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Example: Updating balance through a POST request (a very basic example)
        String accountNumber = request.getParameter("accountNumber");
        double newBalance = Double.parseDouble(request.getParameter("balance"));

        // Update balance (for demonstration purposes, without validation)
        this.accountNumber = accountNumber;
        this.balance = newBalance;

        response.setContentType("text/html");
        response.getWriter().println("<h1>Balance updated successfully!</h1>");
        response.getWriter().println("<p>New Balance: $" + balance + "</p>");
    }
}
