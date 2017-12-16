<%-- 
    Document   : confirmationPage
    Created on : 16-11-2017, 09:56:25
    Author     : Christian Kolz Barth
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int length = (int) session.getAttribute("length");
    int width = (int) session.getAttribute("width");
    int height = (int) session.getAttribute("height");
    String sideDrawing = (String) session.getAttribute("drawingfromside");
    String topDrawing = (String) session.getAttribute("drawingfromtop");
    User user = (User) session.getAttribute("user");
    String option = (String) session.getAttribute("optionforskur");
%>
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
                            <a class="nav-link text-uppercase text-expanded">Velkommen: <% out.println(user.getEmail());%></a>
                        </li>
                        <li class="nav-item active px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="index.html">Log out</a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="allorderscustomer.jsp">View orders</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container" align="center">
            <div class="bg-faded2 p-4 my-4">
                <h1 class="text-shadow text-black">Top Carport tegning</h1>
                <svg width="50%" 
                     viewBox="0 0 <%=length + 101%> <%=width + 81%>">
                <defs>
                <marker id="beginArrow" 
                        markerWidth="9" markerHeight="9" 
                        refX="0" refY="4" 
                        orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000;" />
                </marker>
                <marker id="endArrow" 
                        markerWidth="9" markerHeight="9" 
                        refX="8" refY="4" 
                        orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
                </defs>
                <svg x="101" y="0" width="<%=length + 1%>" height="<%=width + 1%>" 
                     viewBox="0 0 <%=length + 1%> <%=width + 1%>">
                <% out.println(topDrawing);%>
                </svg>
                <!-- Vertical line 1 -->
                <line x1="40"  y1="0" x2="40" y2="<%=width%>" 
                      style="stroke:#006600;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"/>
                <text x="25" y="<%=width / 2%>"
                      font-size="15px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Width: <%=width%></text>
                <!-- Vertical line 2 -->
                <line x1="90"  y1="36" x2="90" y2="<%=width - 30%>" 
                      style="stroke:#006600;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"/>
                <text x="75" y="<%=(width - 35) / 2%>"
                      font-size="15px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Width: <%=width - 70%></text>
                <!-- Horizontal line %-->
                <line x1="100"  y1="<%=width + 40%>" x2="<%=length + 100%>"   y2="<%=width + 40%>" 
                      style="stroke:#006600;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"/>
                <text x="<%=length / 2 + 100%>" y="<%=width + 65%>"
                      font-size="15px"
                      text-anchor="middle">Length: <%=length%></text>
                </svg>
                <br>
                <h1 class="text-shadow text-black">Side Carport tegning</h1>
                <svg width="50%" 
                     viewBox="0 0 <%=length + 101%> <%=height + 81%>">
                <defs>
                <marker id="beginArrow" 
                        markerWidth="9" markerHeight="9" 
                        refX="0" refY="4" 
                        orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000;" />
                </marker>
                <marker id="endArrow" 
                        markerWidth="9" markerHeight="9" 
                        refX="8" refY="4" 
                        orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
                </defs>
                <svg x="101" y="0" width="<%=length + 1%>" height="<%=height + 1%>" 
                     viewBox="0 0 <%=length + 1%> <%=height + 1%>">
                <% out.println(sideDrawing);%>
                </svg>
                <!-- Vertical line 1-->
                <line x1="40"  y1="0" x2="40" y2="<%=height%>" 
                      style="stroke:#006600;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"/>
                <text x="25" y="<%=height / 2%>"
                      font-size="15px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Height: <%=height%></text>
                <!-- Vertical line 2 -->
                <line x1="90"  y1="34" x2="90" y2="<%=height%>" 
                      style="stroke:#006600;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"/>
                <text x="75" y="<%=(height - 30) / 2%>"
                      font-size="15px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Height: <%=height - 30%></text>
                <!-- Horizontal line %-->
                <line x1="100"  y1="<%=height + 40%>" x2="<%=length + 100%>"   y2="<%=height + 40%>" 
                      style="stroke:#006600;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"/>
                <text x="<%=length / 2 + 100%>" y="<%=height + 65%>"
                      font-size="15px"
                      text-anchor="middle">Length: <%=length%></text>
                </svg>
                <br>
                <br>
                <form name="confirmordernow" action="ConfirmOrderServlet" method="POST">
                    <h4 class="text-shadow text-white">Er du sikker på dit køb?</h4>
                    <br>
                    <button class="btn btn-secondary" type="submit" name="action" value="confirmorder">Ja</button>
                </form>
                <br><br>
                <a href="calculatorpage.jsp"><h4>Nej det er jeg ikke. Jeg vil godt bestille en anden carport</h4></a>
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
