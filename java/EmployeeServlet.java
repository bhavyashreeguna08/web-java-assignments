import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Get form data
        String empName = request.getParameter("empName");
        double basicPay = Double.parseDouble(request.getParameter("basicPay"));
        double hra = Double.parseDouble(request.getParameter("hra"));
        double da = Double.parseDouble(request.getParameter("da"));
        double deductions = Double.parseDouble(request.getParameter("deductions"));

        // Calculate net pay
        double grossPay = basicPay + hra + da;
        double netPay = grossPay - deductions;

        // Generate response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("table, th, td {");
        out.println("  border: 1px solid black;");
        out.println("  border-collapse: collapse;");
        out.println("}");
        out.println("th, td {");
        out.println("	background-color: #fdfefe;");
        out.println("	font-size:20px;");
        out.println("}");
        out.println("body {");
        out.println("	background-color:#d6eaf8");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Employee Details</h1>");
        out.println("<table style='width:50%'>");
        out.println("<tr><th>Name</th><td>" + empName + "</td></tr>");
        out.println("<tr><th>Basic Pay</th><td>₹" + basicPay + "</td></tr>");
        out.println("<tr><th>HRA</th><td>₹" + hra + "</td></tr>");
        out.println("<tr><th>DA</th><td>₹" + da + "</td></tr>");
        out.println("<tr><th>Deductions</th><td>₹" + deductions + "</td></tr>");
        out.println("<tr><th>Gross Pay</th><td>₹" + grossPay + "</td></tr>");
        out.println("<tr><th>Net Pay</th><td>₹" + netPay + "</td></tr>");
        out.println("</table>");
        out.println("<br><br>");
        out.println("<a href='EmployeeForm.html'> Back </a>");
        out.println("</body></html>");
    }
}
