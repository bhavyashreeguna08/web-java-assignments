<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Account</title>
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
            text-align: center;
            margin-top: 20px;
            color: #2980b9;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>View Bank Account</h1>
    <!-- <form method="post">
        <label for="accountNumber">Account Number: </label>
        <input type="text" name="accountNumber" required><br><br>
        <input type="submit" value="View Account">
        
    </form> -->

    <%
    //String accountNumber = request.getParameter("accountNumber");
    //if (accountNumber != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_db", "root", "Leoleoleo123");

            String query = "SELECT * FROM bank_accounts";
            PreparedStatement ps = con.prepareStatement(query);
            //ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.isBeforeFirst()) { // Check if there are any results
          %>
            <table>
                <tr>
                    <th>Account Number</th>
                    <th>Account Holder</th>
                    <th>Balance</th>
                </tr>
          <%
            while (rs.next()) {
%>
                <tr>
                    <td><%= rs.getString("accountNumber") %></td>
                    <td><%= rs.getString("accountHolder") %></td>
                    <td><%= rs.getDouble("balance") %></td>
                </tr>
<%
       }
     %>
            </table>
<%
             } else {
                 out.println("<h3>No accounts found.</h3>");
             }
             con.close(); // Close the connection
         } catch (Exception e) {
             e.printStackTrace();
             out.println("<h3>An error occurred while retrieving account details.</h3>");
         }
     %>

     <h3>
         <a href="deleteAccount.jsp">To delete Account</a> &emsp;
         <a href="updateAccount.jsp">To update Account</a> &emsp;
         <a href="creatAccount.jsp">Create a new Account</a> &emsp;
        <a href="readAccountByAccNo.jsp"> View Account By Account Number</a>
     </h3>
</body>
</html>
