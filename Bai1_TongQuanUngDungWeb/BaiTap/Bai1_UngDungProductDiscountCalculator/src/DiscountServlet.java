import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = 0;
        float discount_percent = 0;
        float discount = 0;
        float total = 0;
        try {
             price = Float.parseFloat(request.getParameter("price"));
             discount_percent = Integer.parseInt(request.getParameter("discount_percent"));
             discount = (float) (price * discount_percent * 0.01);
             total = price - discount;
        } catch (NumberFormatException ex) {
            ex.getMessage();
        }

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product description: " + description + "</h1>");
        writer.println("<h1>Price: " + price + "</h1>");
        writer.println("<h1>Discount percent: " + discount_percent + "</h1>");
        writer.println("<h1>Discount: " + discount + "</h1>");
        writer.println("<h1>Total: " + total + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
