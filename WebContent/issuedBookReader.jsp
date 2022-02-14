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
<title>Issued Books</title>
</head>
<body>
<%   
DBUtil db=new DBUtil();		
List<IssueBook> issuebook = DBUtil.showIssuedBooks();
%>

<a href="readerHome.jsp" >Back to home</a>
<table>
  <tr>
   
    <th>Issue Date</th>
    <th>Return Date</th>
    <th>Book Name</th>
    <th>Name</th>
    <th>Return Status</th>
    <th>Fine Amount</th>
    <th>Book ID</th>
    <th>User ID</th>
  </tr>
  
<%
if(!issuebook.isEmpty()){ 
	
	for(IssueBook b:issuebook){ %>
	<tr>
	<td> <%= b.getIssuedate() %></td>
    <td> <%= b.getReturndate() %></td>
    <td> <%= b.getBookname() %></td>
    <td> <%= b.getName() %></td>
    <td> <%= b.getStatus() %></td>
    <td> <%= b.getFineamount() %></td>
    <td> <%= b.getBookId() %></td>
    <td> <%= b.getUserId() %></td>
 				
	<% }
 }%>
  </tr>
 </table>


</body>
</html>