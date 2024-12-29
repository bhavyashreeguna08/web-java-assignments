import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	
	private static final String URL = "jdbc:mysql://localhost:3306/assignment_db";
	private static final String USER = "root";
	private static final String PWD = "Leoleoleo123";
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String action = req.getParameter("action");
		
		try {
			if("Create".equals(action))
			{
				createOrder(req, res);
			}
			else if("Update".equals(action))
			{
				updateOrder(req, res);
			}
			else if("Delete".equals(action))
			{
				deleteOrder(req, res);
			}	
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();		
		}
		
	}
	
	//Create Order
	private void createOrder(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ClassNotFoundException
	{
		String orderId = req.getParameter("orderId");
		String productName = req.getParameter("productName");
		String quantity = req.getParameter("quantity");
		String price = req.getParameter("price");
		String address = req.getParameter("address");
		
		String query = "INSERT INTO product_orders (order_id, product_name, quantity, price, shipping_address) VALUES (?, ?, ?, ?, ?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement psmt = con.prepareStatement(query))
		{
			psmt.setInt(1, Integer.parseInt(orderId));
			psmt.setString(2, productName);
			psmt.setInt(3, Integer.parseInt(quantity));
			psmt.setDouble(4, Double.parseDouble(price));
			psmt.setString(5, address);
			
			psmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		res.sendRedirect("OrderServlet?action=view");
	}
	
	//Update Order
	private void updateOrder(HttpServletRequest req, HttpServletResponse res) throws IOException, ClassNotFoundException
	{
		String orderId = req.getParameter("orderId");
		String productName = req.getParameter("productName");
		String quantity = req.getParameter("quantity");
		String price = req.getParameter("price");
		String address = req.getParameter("address");
		
		String query = "UPDATE product_orders SET product_name = ?, quantity = ?, price = ?, shipping_address = ? WHERE order_id = ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement psmt = con.prepareStatement(query))
		{	
			psmt.setString(1, productName);
			psmt.setInt(2, Integer.parseInt(quantity));
			psmt.setDouble(3, Double.parseDouble(price));
			psmt.setString(4, address);
			psmt.setInt(5, Integer.parseInt(orderId));
			
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		res.sendRedirect("OrderServlet?action=view");
	}
	
	//Delete Order
	private void deleteOrder(HttpServletRequest req, HttpServletResponse res) throws IOException, ClassNotFoundException
	{
		String orderId = req.getParameter("orderId");
		
		String query = "DELETE FROM product_orders WHERE order_id = ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement psmt = con.prepareStatement(query))
		{	
			psmt.setInt(1, Integer.parseInt(orderId));
			
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		res.sendRedirect("OrderServlet?action=view");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String action = req.getParameter("action");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		if("view".equals(action))
		{
			//Views Orders
			
			out.println("<h2> Order List </h2>");
			
			String query = "SELECT * FROM product_orders";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try(Connection con = DriverManager.getConnection(URL, USER, PWD);
					PreparedStatement psmt = con.prepareStatement(query);
					ResultSet rs = psmt.executeQuery())
			{
				out.println("<html>");
		        out.println("<head>");
		        out.println("<style>");
		        out.println("table, th, td {");
		        out.println("  border: 1px solid black;");
		        out.println("  border-collapse: collapse;");
		        out.println("}");
		        out.println("th, td {");
		        out.println("	background-color: #fdfefe ;");
		        out.println("}");
		        out.println("body {");
		        out.println("	background-color:#d6eaf8");
		        out.println("}");
		        out.println("</style>");
		        out.println("</head>");
		        out.println("<body>");
				out.println("<table style='width:40%'><tr><th> Order ID </th> <th> Product Name </th> <th> Quantity </th> <th> Price </th> <th> Address </th> </tr>");;
				
				while(rs.next())
				{
					out.println("<tr>");
					out.println("<td>" +rs.getInt("order_id")+ "</td>");
					out.println("<td>" +rs.getString("product_name")+ "</td>");
					out.println("<td>" +rs.getInt("quantity")+ "</td>");
					out.println("<td>" +rs.getDouble("price")+ "</td>");
					out.println("<td>" +rs.getString("shipping_address")+ "</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<br><br><a href='OrderForm.html'> Back </a>");
				out.println("</body>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Done..");
	}
}
