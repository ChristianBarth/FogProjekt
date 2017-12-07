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
                <td><div class="dropdown"><button onclick="myFunction()" class="dropbtn"><%=orders.getStatus()%></button><div id="myDropdown" class="dropdown-content">
                            <a href="JavaScriptServlet?ordernumber=<%=orders.getOrdernumber()%>&status=Accepted">Accepted</a>
                            <a href="JavaScriptServlet?ordernumber=<%=orders.getOrdernumber()%>&status=Paid">Paid</a>
                            <a href="JavaScriptServlet?ordernumber=<%=orders.getOrdernumber()%>&status=Shipped">Shipped</a>
                            <a href="JavaScriptServlet?ordernumber=<%=orders.getOrdernumber()%>&status=Declined">Declined</a>
                        </div></div></td>
            <form action="OrderInfoServletAdminOnClick">
                <select name="options">
                    <option value="<%=orders.getOrdernumber()%>&status=Accepted">Accepted</option>
                    <option value="<%=orders.getOrdernumber()%>">Paid</option>
                    <option value="<%=orders.getOrdernumber()%>">Shipped</option>
                    <option value="<%=orders.getOrdernumber()%>">Declined</option>
                </select>
                <br><br>
                <input type="submit">
            </form>

        </tr>
        <% }%>
    </table>
    <br>
    <a href="employeepage.jsp">Back to employeepage</a>
</body>
</html>
