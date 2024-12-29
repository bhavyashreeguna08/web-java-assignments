<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Marks Processing</title>
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
        .message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1> Marks Processing</h1>
    <br>
    <form action="MarksInsertServlet" method="POST">
        <h2> Enter Student Details: </h2>
        
        <label for="usn">USN: </label>
        <input type="text" id="usn" name="usn" required><br><br>
        
        <label for="name">Name: </label>
        <input type="text" id="name" name="name" required><br><br>
        
        <h2> Enter Marks: </h2>
        <br>
        <label for="s1">Research Methodology: </label>
        <input type="number" id="s1" name="s1" min="0" max="100" required><br><br>
        
        <label for="s2">DSA: </label>
        <input type="number" id="s2" name="s2" min="0" max="100" required><br><br>
        
        <label for="s3">Mathematics: </label>
        <input type="number" id="s3" name="s3" min="0" max="100" required><br><br>
        
        <label for="s4">Operating System with UNIX: </label>
        <input type="number" id="s4" name="s4" min="0" max="100" required><br><br>
        
        <label for="s5">Software Engineering: </label>
        <input type="number" id="s5" name="s5" min="0" max="100" required><br><br>
        
        <label for="s6">Computer Networks: </label>
        <input type="number" id="s6" name="s6" min="0" max="100" required><br><br>
        
        <input type="submit" value="Submit"> 
        &emsp;
   		<b style=font-size:18px> <a href="viewMarks.jsp">View Ranking of All Students</a>
   		&emsp;
   		<a href="AssgnHome.html">Home</a> </b>
   		
    </form> 
    
</body>
</html>
