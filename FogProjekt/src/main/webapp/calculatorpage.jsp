<%-- 
    Document   : inputPage
    Created on : 15-11-2017, 13:36:15
    Author     : Christian Kolz Barth
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InputPage</title>
    </head>
    <body>
        <h1>Byg din egen carport</h1>
        
        <h2>Det hele foregår i cm. <% out.println(user.getEmail()); %></h2>
        <br>
        Indtast dine ønskede mål i felterne nedenfor.
        <form name="showusercarport" action="DrawingServlet" method="POST">
            <input type="hidden" name="action" value="draw">
            <br>
            Længde i cm:
            <br>
            <input type="text" name="length" value="" placeholder="Maks 999"/> 
            <br>
            Bredde i cm:
            <br>
            <input type="text" name="width" value="" placeholder="Maks 999"/>
            <br>
            Højde i cm:
            <br>
            <input type="text" name="height" value="" placeholder="Maks 999"/>
            <br>
            <br>
            <input type="submit" value="Show Carport"/>
        </form>
    </body>
</html>
