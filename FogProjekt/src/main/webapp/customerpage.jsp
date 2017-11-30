<%-- 
    Document   : customerpage
    Created on : 29-11-2017, 16:03:25
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer page</title>
    </head>
    <body>
        <h1>Hello Customer: <%=request.getParameter( "email" )%> .</h1>
        
        <a href="inputPage.jsp">Order carport</a>
    </body>
</html>
