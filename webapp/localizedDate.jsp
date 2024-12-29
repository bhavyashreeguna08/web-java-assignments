<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Localized Date</title>
<style>
        body {
            background-color: powderblue;
        }
     </style>
</head>
<body>
    <h2>Date in <%= request.getAttribute("locale") %>:</h2>
    <h3><%= request.getAttribute("formattedDate") %></h3>
    <br>
    <a href="LanguageSelect.jsp">Select another language and country</a>
</body>
</html>
