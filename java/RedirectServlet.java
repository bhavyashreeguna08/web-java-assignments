import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user type from session
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");

        if ("student".equals(userType)) {
            // Redirect to educational site for students
            response.sendRedirect("https://www.edx.org/");
        } else if ("professional".equals(userType)) {
            // Redirect to a professional site for working professionals
            response.sendRedirect("https://www.linkedin.com/");
        } else {
            // Handle unknown user types if necessary
            response.getWriter().println("<h3>Unknown user type. Please contact support.</h3>");
        }
    }
}
