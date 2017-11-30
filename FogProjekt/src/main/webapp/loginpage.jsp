<%-- 
    Document   : loginpage
    Created on : 29-11-2017, 14:20:04
    Author     : Christian Kolz Barth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login side</h1>
        <br>
        <form name="loginuser"action="LoginServlet" method="POST">
            <input type="hidden" name="action" value="login">
            Indtast din mail:
            <br>
            <input type="text" name="email" value="" placeholder="bruger@mail.dk"/>
            <br><br>
            Indtast din adgangskode:
            <br>
            <input type="password" name="password" value="" placeholder="*******"/>
            <br><br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
