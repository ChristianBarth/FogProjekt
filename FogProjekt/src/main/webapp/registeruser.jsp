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
           Indtast e-mail: <input type="text" name="email" value="" placeholder="E-mail"/> 
            <br>
            Indtast Password <input type="text" name="password" value="" placeholder="Password"/>
            <br>
            <input type="submit" value="BuildCarport"/>
        </form>
    </body>
</html>
