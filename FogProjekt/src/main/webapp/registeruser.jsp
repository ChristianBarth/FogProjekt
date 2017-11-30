<%-- 
    Document   : registeruser
    Created on : 29-11-2017, 14:22:45
    Author     : asger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <h1>Register</h1>
        <h2>Her</h2>
        <br>
        Register right here
        <form name="registeruser" action="RegisterServlet" method="POST">
            <input type="hidden" name="action" value="register">
            <br>
            Indtast e-mail:
            <br>
            <input type="text" name="email" value=""/>
            <br>
            Indtast Password:
            <br>
            <input type="password" name="password1" value=""/>
            <br>
            Indtast Password igen:
            <br>
            <input type="password" name="password2" value=""/>
            <br>
            Indtast telefon nummer:
            <br>
            <input type="text" name="phonenumber" value=""/>
            <br>
            <br>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
