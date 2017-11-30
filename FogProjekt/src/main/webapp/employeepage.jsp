<%-- 
    Document   : employeepage
    Created on : 29-11-2017, 16:03:12
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee page</title>
    </head>
    <body>
        <h1>Hello Employee: <%=request.getParameter( "email" )%> .</h1>
        
        <a href="allorders.jsp">Click here to see all orders from customers</a>
    </body>
</html>
