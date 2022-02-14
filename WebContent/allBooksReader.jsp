<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.librarymanagement.dao.*"%>
<%@ page import="com.librarymanagement.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="formStyle.css">
<title>All Books</title>
</head>
<body>
<%   
DBUtil db=new DBUtil();		
List<Book> books = DBUtil.showBook();
%>
<a href="readerHome.jsp" >Back to home</a>
<table>
  <tr>
 
    <th>Book Name</th>
    <th>Author</th>
    <th>Category</th>
    <th>Published Year </th>
   
  </tr>
  
<%
if(!books.isEmpty()){ 
	
	for(Book b:books){ %>
	<tr>
    <td> <%= b.getBookName() %></td>
    <td> <%= b.getAuthorName() %></td>
    <td> <%= b.getCategory() %></td>
    <td> <%= b.getPublishedYear() %></td>
 				
	<% }
 }%>
  </tr>
 </table>

</body>
</html>