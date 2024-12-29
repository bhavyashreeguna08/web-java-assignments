<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Account</title>
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
    <h1>Delete Bank Account</h1>
    <form action="DeleteAccountServlet" method="post">
        <label for="accountNumber">Account Number: </label>
        <input type="text" name="accountNumber" required><br><br>
        <h3>
        &emsp;
        <a href="readAccount.jsp"> View Accounts</a>
        &emsp;
        <a href="readAccountByAccNo.jsp"> View Account By Account Number</a>
        &emsp;
        <a href="creatAccount.jsp"> Create a new Account</a>
        &emsp;
        <a href="updateAccount.jsp"> To update Account</a>
        </h3>
        <input type="submit" value="Delete Account">
    </form>
</body>
</html>
