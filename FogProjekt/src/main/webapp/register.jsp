<%-- 
    Document   : register
    Created on : 17-11-2017, 16:25:15
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <br>
        <form action="RegisterServlet">
            <input type="hidden" name="action" value="register">
            Email:<br>
            <input type="text" name="email" value="Type your email">
            <br>
            Password:<br>
            <input type="password" name="password" value="Type your password">
            <br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
