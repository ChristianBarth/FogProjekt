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
            <input type="text" name="length" value="" placeholder="Max 1000"/> 
            <br>
            Bredde i cm:
            <br>
            <input type="text" name="width" value="" placeholder="Max 1000"/>
            <br>
            Højde i cm:
            <br>
            <input type="text" name="height" value="" placeholder="Max 1000"/>
            <br>
            <br>
            <select name="option"> 
                <option value="YesSkur">Med skur</option>
                <option value="NoSkur">Uden Skur</option>
            </select>
            <input type="submit" value="Show Carport"/>
        </form>

        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <h2>Error! Something went wrong!</h2>
        <p><%=error%></p>
        <% }%>
    </body>
</html>
