<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
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
    <h2>Login Form</h2>
    <form action="LoginServlet" method="POST">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br><br>

        <label for="userType">User Type:</label>
        <select name="userType" id="userType" required>
            <option value="student">Student</option>
            <option value="professional">Working Professional</option>
        </select><br><br>

        <input type="submit" value="Login">
    </form>
    <br><br> 
    <a href="AssgnHome.html"> Home </a>
</body>
</html>
