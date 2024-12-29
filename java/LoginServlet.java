import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve login credentials and user type
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
 
        // Validate user credentials (simple validation for example purposes)
        if ("user123".equals(username) && "password123".equals(password)) {
            // Set a cookie for the user
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60); // 1 hour cookie expiration
            response.addCookie(userCookie);

            // Set user type in session
            request.getSession().setAttribute("userType", userType);

            // Forward the request to the redirect servlet
            request.getRequestDispatcher("RedirectServlet").forward(request, response);
        } else {
            // If login fails, show error message
            response.getWriter().println("<h3>Invalid username or password. Please try again.</h3>");
        }
    }
}
