<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Records</title>
    <style>
        body {
            background-color: #d6eaf8;
            font-family: Arial, sans-serif;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            border: 1px solid #a9cce3;
            text-align: center;
        }
        th {
            background-color: #2980b9;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #d4e6f1;
        }
        h2 {
            text-align: center;
            color: #34495e;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #2980b9;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h2>Student Records</h2>
    <table>
        <tr>
            <th>USN</th>
            <th>Name</th>
            <th>Research Methodology</th>
            <th>DSA</th>
            <th>Mathematics</th>
            <th>Operating System with UNIX</th>
            <th>Software Engineering</th>
            <th>Computer Networks</th>
            <th>Total Marks</th>
            <th>Percentage</th>
            <th>Grade</th>
            <th>Status</th>
        </tr>
        <%
            // Database credentials
            String url = "jdbc:mysql://localhost:3306/assignment_db";
            String user = "root";
            String password = "Leoleoleo123";

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection
                con = DriverManager.getConnection(url, user, password);

                // SQL query to fetch all student records
                String sql = "SELECT * FROM students ORDER BY percentage DESC";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                // Iterate through the result set and display records
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("usn") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("research_methodology") %></td>
            <td><%= rs.getInt("dsa") %></td>
            <td><%= rs.getInt("mathematics") %></td>
            <td><%= rs.getInt("operating_system_unix") %></td>
            <td><%= rs.getInt("software_engineering") %></td>
            <td><%= rs.getInt("computer_networks") %></td>
            <td><%= rs.getInt("total_marks") %></td>
            <td><%= rs.getDouble("percentage") %>%</td>
            <td><%= rs.getString("grade") %></td>
            <td><%= rs.getString("status") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
        <tr>
            <td colspan="12" class="message">Error fetching data.</td>
        </tr>
        <%
            } finally {
                // Close resources
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </table>
    <a href="MarksProcessing.jsp">Add New Student</a>
    <a href="AssgnHome.html">Home</a>
</body>
</html>
