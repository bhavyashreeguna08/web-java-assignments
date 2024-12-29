import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DateLocalizationServlet")
public class DateLocalizationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve selected language and country from the form
        String language = request.getParameter("language");
        String country = request.getParameter("country");
        
        // Create a locale based on the selected language and country
        Locale locale = new Locale(language, country);
        
        // Get the current date
        Date currentDate = new Date();
        
        // Format the date based on the selected locale
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(currentDate);
        
        // Send the formatted date to the JSP page
        request.setAttribute("formattedDate", formattedDate);
        request.setAttribute("locale", locale.getDisplayLanguage(locale) + " (" + locale.getCountry() + ")");
        
        // Forward to JSP page to display the formatted date
        request.getRequestDispatcher("localizedDate.jsp").forward(request, response);
    }
}
