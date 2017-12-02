<%-- 
    Document   : orderinfo
    Created on : 23-11-2017, 11:16:10
    Author     : PC
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Product> listorders = (ArrayList<Product>) request.getAttribute("detailsfromid"); %>
<% int totalPrice = (int) request.getAttribute("totalprice"); %>
<!DOCTYPE html>
<html>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
        th {
            text-align: left;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Information</title>
    </head>
    <body>
        <h1>Order information on a specific order: </h1>
        <table>
            <tr>
                <th>Titel</th>
                <th>Længde</th>
                <th>Antal</th>
                <th>Enhed</th>
                <th>Beskrivelse</th>
                <th>Pris</th>
            </tr>
            <% for (Product orders : listorders) { %>
            <tr>
                <td><% out.println(orders.getName()); %></td>
                <td><% out.println(orders.getLength()); %></td>
                <td><% out.println(orders.getAmount()); %></td>
                <td><% out.println(orders.getUnit()); %></td>
                <td><% out.println(orders.getDescription()); %></td>
                <td><% out.println(orders.getPrice()); %></td>
            </tr>
            <% } %>
        </table>
        <h2>Total price of the entire carport: <% out.println(totalPrice);%> DKK </h2>
        <br><br>
        <a href="allordersadmin.jsp">Back to all orders of users</a>
        <br>
        <br>
        <a href="employeepage.jsp">Back to employeepage</a>
    </body>
</html>
