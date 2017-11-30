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
            <th>Email</th>
        </tr>
        <% ArrayList<Order> ListofOrders = LogicFacade.getOrderLines();
            for (Order orders : ListofOrders){ %>
            <tr>
                <td><% out.println(orders.getOrdernumber()); %></td>
            <td><% out.println(orders.getEmail()); %></td>
            </tr>
        <% } %>
        </table>
            <form name="findordernumber" action="OrderInfoServlet" method="POST">
            <input type="hidden" name="action" value="ordernumber">
            <br>
            Længde i cm: <input type="text" name="number" value="" placeholder="Type ordernumber"/>
            <br>
            <br>
            <input type="submit" value="Search"/>
            </form>
        <br>
            <a href="index.html">Back to index</a>
    </body>
</html>
