<%-- 
    Document   : receivedorder
    Created on : 01-12-2017, 16:18:59
    Author     : Oliver
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% User user = (User) session.getAttribute("user"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation on your order</title>
    </head>
    <body>
        <h1>Here is your confirmation on your order <% out.println(user.getEmail()); %>. </h1>
        <h2>Your order has been received and will be reviewed as fast as possible.</h2>
        <br>
        <h2> NOTE that we have not charged your creditcard until we have contacted you back. You will be hearing from us within 1 - 2 days. </h2>
        
        <a href="customerpage.jsp">Back to customerpage</a>
    </body>
</html>
