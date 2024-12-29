<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date Localization</title>
<style>
        body {
            background-color: powderblue;
        }
        label {
            display: inline-block;
            width: 200px;
            margin-bottom: 10px;
        }
        input[type="text"] {
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
    <h2>Select Language and Country</h2>
    
    <form action="DateLocalizationServlet" method="post">
        <label for="language">Select Language:</label>
        <select name="language" id="language">
        	<option value="ta">Tamil</option>
        	<option value="kn">Kannada</option>
        	<option value="ml">Malayalam</option>
            <option value="en">English</option>
            <option value="fr">French</option>
            <option value="de">German</option>
            <option value="ja">Japanese</option>
            
        </select><br><br>

        <label for="country">Select Country:</label>
        <select name="country" id="country">
        	<option value="IN">India</option>
            <option value="US">United States</option>
            <option value="FR">France</option>
            <option value="DE">Germany</option>
            <option value="JP">Japan</option>
            
        </select><br><br>

        <input type="submit" value="Get Date Format">
        <h3> <a href="AssgnHome.html"> Home </a></h3>
    </form>
</body>
</html>
