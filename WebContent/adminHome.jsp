<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url("images/admin2.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  
}
</style>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="formStyle.css">
<title>Admin Home</title>
</head>
<body>

<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
}
%>


  <div class="topnav">
		
		<a  href="#home">Home</a>
		<a href="addBook.jsp">Add Book</a>
        <a href="adminBookSearch.jsp">Search Book</a>
        <a href="returnBook.jsp">Return Book</a>
        <a href="issueBook.jsp">Issue Book</a>
       
 
  </div>
	
</body>
</html>