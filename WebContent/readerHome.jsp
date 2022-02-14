<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.librarymanagement.dao.*"%>
<%@ page import="com.librarymanagement.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url("images/reader2.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  
}
</style>

<meta charset="ISO-8859-1">
<title>Reader Home</title>
</head>
<body>

<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
}
%>
   <div class="topnav">
		  <a  href="#home">Home</a>
          <a href="allBooksReader.jsp">All books</a>
		  <a href="readerBookSearch.jsp">Search book</a>
		  <a href="issuedBookReader.jsp">Issued book</a>
		  <a href="renewBook.jsp">Renew book</a>
		
   </div>
		 
		 
		 
</body>
</html>