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
        <table>
        <tr>
            <th>Ordrenummer</th>
            <th>Kundenummer</th>
        </tr>
        <% ArrayList<Order> ListofOrders = LogicFacade.getOrders();
            for (Order orders : ListofOrders){ %>
            <tr>
                <td><a href="OrderInfoServlet"><% out.println(orders.getOrdernumber()); %></a></td>
            <td><% out.println(orders.getCustomerid()); %></td>
            </tr>
        <% } %>
        </table>
    </body>
</html>
