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

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 80px;
            overflow: auto;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 10px 5px;
            text-decoration: none;
            display: block;
        }

        .dropdown a:hover {background-color: #f1f1f1}

        .show {display:block;}
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

            <% for (Order orders : orderlines) {
                    Order order = new Order(orders.getOrdernumber());
                    sessionordernumber.setAttribute("specificorder", order);%>
            <tr>
                <td> <a href="OrderInfoServletAdminOnClick?ordernumber=<%=orders.getOrdernumber()%>"> <% out.println(orders.getOrdernumber()); %> </a></td>
                <td><% out.println(orders.getEmail());%></td>
                <td><a href="tel://45-<%=orders.getPhonenumber()%>"> <% out.println("+45 " + orders.getPhonenumber()); %> </a></td>
                <td><% out.println(orders.getTime()); %></td>
                <td><% out.println(orders.getTotalprice());%></td>
                <td><div class="dropdown"><button onclick="myFunction()" class="dropbtn"><%=orders.getStatus()%></button><div id="myDropdown" class="dropdown-content">
                            <a href="JavaScriptServlet?status=Accepted">Accepted</a>
                            <a href="JavaScriptServlet?status=Paid">Paid</a>
                            <a href="JavaScriptServlet?status=Shipped">Shipped</a>
                            <a href="JavaScriptServlet?status=Declined">Declined</a>
                        </div></div></td>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="employeepage.jsp">Back to employeepage</a>

        <script>
            /* When the user clicks on the button, 
             toggle between hiding and showing the dropdown content */
            function myFunction() {
                
                document.getElementById("myDropdown").classList.toggle("show");
            }

// Close the dropdown if the user clicks outside of it
            window.onclick = function (event) {
                if (!event.target.matches('.dropbtn')) {

                    var dropdowns = document.getElementsByClassName("dropdown-content");
                    var i;
                    for (i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
        </script>
    </body>
</html>
