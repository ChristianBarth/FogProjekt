<%-- 
    Document   : orderinfo
    Created on : 23-11-2017, 11:16:10
    Author     : PC
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Product> listorder = (ArrayList<Product>) request.getAttribute("detailsfromid"); %>
<% int totalPrice = (int) request.getAttribute("totalprice"); %>
<% User user = (User) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Order information</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet">
    </head>
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
    <body>

        <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Johannes Fog</div>
        <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Firskovsvej 20| 2800 Lyngby | 45 87 10 01</div>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
            <div class="container">
                <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item active px-lg-4">
                            <a class="nav-link text-uppercase text-expanded">Velkommen admin: <% out.println(user.getEmail());%></a>
                        </li>
                        <li class="nav-item active px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="index.html">Log out</a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="OrderLinesServletAdmin">Back to orders</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container" align="center">
            <div class="bg-faded2 p-4 my-4">
                <h1 class="text-shadow text-white"  text-align: center>Ordre information</h1>
                <table>
                    <tr>
                        <th><h4 class="text-shadow text-white">Titel</h4></th>
                        <th><h4 class="text-shadow text-white">Længde</h4></th>
                        <th><h4 class="text-shadow text-white">Antal</h4></th>
                        <th><h4 class="text-shadow text-white">Enhed</h4></th>
                        <th><h4 class="text-shadow text-white">Beskrivelse</h4></th>
                        <th><h4 class="text-shadow text-white">Pris</h4></th>
                    </tr>
                    <% for (Product orders : listorder) { %>
                    <tr>
                        <td><h6 class="text-shadow text-white"><% out.println(orders.getName()); %></h6></td>
                        <td><h6 class="text-shadow text-white"><% out.println(orders.getLength()); %></h6></td>
                        <td><h6 class="text-shadow text-white"><% out.println(orders.getAmount()); %></h6></td>
                        <td><h6 class="text-shadow text-white"><% out.println(orders.getUnit()); %></h6></td>
                        <td><h6 class="text-shadow text-white"><% out.println(orders.getDescription()); %></h6></td>
                        <td><h6 class="text-shadow text-white"><% out.println(orders.getPrice()); %></h6></td>
                    </tr>
                    <% } %>
                </table>
                <br>
                <h3 class="text-shadow text-white">Total pris af carport: <% out.println(totalPrice);%> DKK </h3>
            </div>
        </div>
        <br>

        <!-- /.container -->

        <footer class="bg-faded text-center py-5">
            <div class="container">
                <p class="m-0">Copyright &copy; Fog Projekt 2017</p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
