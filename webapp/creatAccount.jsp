<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
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
     </style>
</head>
<body>
    <h1>Create a Bank Account</h1>
    <form action="CreateAccountServlet" method="post">
        <label for="accountNumber">Account Number: </label>
        <input type="text" name="accountNumber" required><br><br>
        
        <label for="accountHolder">Account Holder: </label>
        <input type="text" name="accountHolder" required><br><br>
        
        <label for="balance">Initial Balance: </label>
        <input type="number" name="balance" required><br><br>
        
        <input type="submit" value="Create Account">  
       	<h3>
        &emsp;
        <a href="readAccount.jsp"> View Accounts</a>
        &emsp;
        <a href="readAccountByAccNo.jsp"> View Account By Account Number</a>
        &emsp;
        <a href="deleteAccount.jsp"> To delete Account</a>
        &emsp;
        <a href="updateAccount.jsp"> To update Account</a>
        </h3>
    </form>
    <br><br>
    <a href="AssgnHome.html">Home</a>
</body>
</html>
