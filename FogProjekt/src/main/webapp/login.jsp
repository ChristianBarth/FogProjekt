<%-- 
    Document   : login
    Created on : 17-11-2017, 15:27:01
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <br>
        <form action="LoginServlet">
            <input type="hidden" name="action" value="login">
            Email:<br>
            <input type="text" name="email" value="Type your email">
            <br>
            Password:<br>
            <input type="password" name="password" value="Type your password">
            <br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
