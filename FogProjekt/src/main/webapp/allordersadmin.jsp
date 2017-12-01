<%-- 
    Document   : allorders
    Created on : 23-11-2017, 12:07:48
    Author     : PC
--%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Orders</title>
    </head>
    <body>
        <h1>All orders right now:</h1>
        <form name="findordernumber" action="OrderInfoServletAdmin" method="POST">
            <input type="hidden" name="action" value="ordernumberadmin">
            <br>
            Søg efter ordrenummer: 
            <br>
            <input type="text" name="number" value=""/>
            <input type="submit" value="Search"/>
        </form>
        <br><br>
        <table>
            <tr>
                <th>Ordrenummer</th>
                <th>Email</th>
                <th>Telefon</th>
                <th>Dato</th>
                <th>Status</th>
            </tr>
            <% ArrayList<Order> ListofOrders = LogicFacade.getOrderLinesAdmin();
            for (Order orders : ListofOrders) { %>
            <tr>
                <td><% out.println(orders.getOrdernumber()); %></td>
                <td><% out.println(orders.getEmail()); %></td>
                <td><% out.println(orders.getPhonenumber()); %></td>
                <td><% out.println(orders.getTime()); %></td>
                <td><% out.println(orders.getStatus()); %></td>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="index.html">Back to index</a>
    </body>
</html>
