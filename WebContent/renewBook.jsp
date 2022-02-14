<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Renew Book</title>
</head>
<body>
<center>
<a href="readerHome.jsp">Back to home</a>

<form action="RenewBook">

    <label>Return Date:</label>
           <input type="date" name="returndate"><br>
    <input type="text" name="bookname" placeholder="Book Name"><br>
    <input type="submit" name="submit" value="submit">
</form>
</center>
</body>
</html>