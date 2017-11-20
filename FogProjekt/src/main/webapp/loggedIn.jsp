<%-- 
    Document   : loggedIn
    Created on : 17-11-2017, 16:16:29
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kunde side</title>
    </head>
    <body>
        <h1>Hallo kunde <%=request.getParameter( "email" )%> ! </h1>
    </body>
</html>
