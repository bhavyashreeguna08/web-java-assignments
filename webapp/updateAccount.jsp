<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Account</title>
     <style>
        body {
            background-color: powderblue;
        }
        label {
            display: inline-block;
            width: 200px;
            margin-bottom: 10px;
        }
        input[type="text"], input[type="number"] {
            width: 200px;
            padding: 5px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            margin-top: 10px;
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
    <h1>Update Bank Account</h1>
    <form action="UpdateAccountServlet" method="post">
    
        <label for="accountNumber">Account Number: </label>
        <input type="text" name="accountNumber" required><br><br>
        
        <label for="newBalance">New Balance: </label>
        <input type="number" name="newBalance" required><br><br>
        <h3>
        &emsp;
        <a href="readAccount.jsp"> View Accounts</a>
        &emsp;
        <a href="readAccountByAccNo.jsp"> View Account By Account Number</a>
        &emsp;
        <a href="deleteAccount.jsp"> To delete Account</a>
        &emsp;
        <a href="creatAccount.jsp"> create a new Account</a>
        </h3>
        <input type="submit" value="Update Balance">
    </form>
</body>
</html>
