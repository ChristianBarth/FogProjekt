<%-- 
    Document   : customerpage
    Created on : 29-11-2017, 16:03:25
    Author     : PC
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer page</title>
    </head>
    <body>
        <h1>Hello Customer: <% out.print(user.getEmail()); %> .</h1>
        
        <a href="calculatorpage.jsp">Order carport</a>
        <br><br>
        <a href="allorderscustomer.jsp">Click here to see all your orders</a>
        
    </body>
</html>
