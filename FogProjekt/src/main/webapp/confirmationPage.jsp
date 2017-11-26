<%-- 
    Document   : confirmationPage
    Created on : 16-11-2017, 09:56:25
    Author     : Christian Kolz Barth
--%>

<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="FunctionLayer.SVGUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int length = (int) session.getAttribute("length");
    int height = (int) session.getAttribute("height");
    String sideDrawing = (String) session.getAttribute("drawing");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>confirmationPage</title>
    </head>

    <body>
        <h1>Vi modtog dine oplysninger</h1>
        <br>
        <br>
        <svg width="75%" 
             viewBox="0 0 <%=length / 20 + 11%> <%=height / 10 + 40%>">
        <% out.println(sideDrawing);%>
        </svg>
        <br>
        <br>
        <a href="index.html">Back to index</a>
    </body>
</html>
