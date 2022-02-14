<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.librarymanagement.dao.*"%>
<%@ page import="com.librarymanagement.dto.*"%>
<%@ page import="com.librarymanagement.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="formStyle.css">
<title>Search Book</title>
</head>
<body>
<center>
<h5>Search book</h5> 
    <a href="adminHome.jsp">Back To Home</a>
    
    <form action="SearchBookServlet">
         <input type="text" name="name" placeholder="Enter book name"><br>
         <input type="text" name="category" placeholder="Enter book category"><br>
         <input type="submit" name="submit" value="submit"><br>
    </form>	
</center>

<% List<Book> books=(List<Book>)request.getAttribute("books"); %>

 
<%
if(books!=null){ %>
	
	<table>
	  <tr>
	    <th>Book Name</th>
	    <th>Author</th>
	    <th>Category</th>
	    <th>Published Year </th>
	   
	  </tr>
	  
	
	<% for(Book b:books){ %>
	<tr>
    <td> <%= b.getBookName() %></td>
    <td> <%= b.getAuthorName() %></td>
    <td> <%= b.getCategory() %></td>
    <td> <%= b.getPublishedYear() %></td>
    
    
 				
	<% }
	
 }%>
 

</body>
</html>