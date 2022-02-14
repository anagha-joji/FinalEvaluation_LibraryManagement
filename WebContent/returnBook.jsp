<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book</title>
</head>
<body>
<center>

<h5>Return Book Form</h5>
     <a href="adminHome.jsp">Back To Home</a>

     <form action="ReturnBook"> 
     <input type="text" name="bookname" placeholder="Book Name"><br>
     <input type="number" name="userid" placeholder="User Id"><br>
     <input type="submit" name="submit" value="submit">
</form>
</center>

</body>
</html>