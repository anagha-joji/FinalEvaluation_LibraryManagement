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
<title>Issue Book</title>
</head>
<body>

<center>
<h3>Issue Book Form</h3><br>
<a href="adminHome.jsp">Back to home</a><br>


<form action="IssueBook" method="post">
      <label>Issue Date:</label>
           <input type="date" name="issuedate"><br>
      <label>Return Date:</label>
           <input type="date" name="returndate"><br>
           
           <input type="text" name="bookname" placeholder="Book Name"><br>
           <input type="text" name="name" placeholder="Name"><br>
           
           <input type="number" name="bookid" placeholder="Book Id"><br>
           <input type="number" name="userid" placeholder="User Id"><br>
           
           <input type="submit" name="submit" value="submit">
</form>

</center>


<%   
DBUtil db=new DBUtil();		
List<IssueBook> issuebook = DBUtil.showIssuedBooks();
%>

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