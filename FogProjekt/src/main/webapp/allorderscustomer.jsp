<%-- 
    Document   : allorderscustomer
    Created on : 30-11-2017, 20:26:41
    Author     : Oliver
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("user"); %>
<% ArrayList<Order> ListofOrders = LogicFacade.getOrderLinesCustomer(user); %>
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
        <title>All Orders</title>
    </head>
    <body>
        <h1>Here are all your orders:</h1>
        <table>
            <tr>
                <th>Ordrenummer</th>
                <th>Email</th>
                <th>Telefon</th>
                <th>Dato</th>
                <th>Status</th>
            </tr>
            <% for (Order orders : ListofOrders) { %>
            <tr>
                <% if (orders.getStatus().equals("Paid") || (orders.getStatus().equals("Shipped"))) { %>
                <td> <a href="OrderInfoServletCustomerOnClick?ordernumber=<%=orders.getOrdernumber()%>"> <% out.println(orders.getOrdernumber()); %> </a> </td>
                  <% } else { %>
                  <td><% out.println(orders.getOrdernumber()); %>
                  <% } %> </td>
                <td><% out.println(orders.getEmail()); %></td>
                <td><% out.println(orders.getPhonenumber()); %></td>
                <td><% out.println(orders.getTime()); %></td>
                <td><% out.println(orders.getStatus()); %></td>
                <% if (orders.getStatus().equals("Accepted")) {%>
                <td>
                    <form action="CustomerPayServlet">
                        <input name="ordernumber" type="hidden" value="<%=orders.getOrdernumber()%>">
                        <button type="submit">Pay</button>
                    </form>
                </td>
                <% } %>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="customerpage.jsp">Back to customerpage</a>
    </body>
</html>
