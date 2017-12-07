<%-- 
    Document   : allorders
    Created on : 23-11-2017, 12:07:48
    Author     : PC
--%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Order> orderlines = (ArrayList<Order>) session.getAttribute("orderlineswithtotalprice"); %>
<% HttpSession sessionordernumber = request.getSession(); %>
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
                <th>Total Pris</th>
                <th>Status</th>
            </tr>

            <% for (Order orders : orderlines) {%>
            <tr>
                <td> <a href="OrderInfoServletAdminOnClick?ordernumber=<%=orders.getOrdernumber()%>"> <% out.println(orders.getOrdernumber()); %> </a></td>
                <td><% out.println(orders.getEmail());%></td>
                <td><a href="tel://45-<%=orders.getPhonenumber()%>"> <% out.println("+45 " + orders.getPhonenumber()); %> </a></td>
                <td><% out.println(orders.getTime()); %></td>
                <td><% out.println(orders.getTotalprice());%></td>
                <td><% out.println(orders.getStatus());%></td>
                <td>
                    <form action="SelectOptionForStatusServlet">
                        <input name="ordernumber" type="hidden" value="<%=orders.getOrdernumber()%>">
                        <select name="option">
                            <option value="Accepted">Accepted</option>
                            <option value="Paid">Paid</option>
                            <option value="Shipped">Shipped</option>
                            <option value="Declined">Declined</option>
                        </select>
                        <input type="submit" value="Opdater">
                    </form>
                </td>
            </tr>
            <% }%>
        </table>
<br>
<a href="employeepage.jsp">Back to employeepage</a>
</body>
</html>
