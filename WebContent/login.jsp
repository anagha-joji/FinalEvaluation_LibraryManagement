<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Login Form</title>    
    <link rel="stylesheet" href="loginStyle.css">    
</head>    
<body>    
    <h2>Login Page</h2><br> 
    <div class="login">      
    <form action="LoginServlet">
        <label><b>User Name     
        </b>    
        </label>    
        <input type="text" id="username" value="" name="username">    
        <br><br>    
        <label><b>Password     
        </b>    
        </label>    
        <input type="password" id="password" value="" name="password">    
        <br><br>    
        <input type="submit" name="log" id="log" value="Login">       
        <br><br>    
        
    </form> 
</div>       
</body>    
</html>     