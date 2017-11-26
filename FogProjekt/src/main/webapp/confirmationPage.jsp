<%-- 
    Document   : confirmationPage
    Created on : 16-11-2017, 09:56:25
    Author     : Christian Kolz Barth
--%>

<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="FunctionLayer.SVGUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int length = (int) session.getAttribute("length");
    int height = (int) session.getAttribute("height");
    String sideDrawing = (String) session.getAttribute("drawing");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>confirmationPage</title>
    </head>

    <body>
        <h1>Vi modtog dine oplysninger</h1>
        <br>
        <br>
        <svg width="75%" 
             viewBox="0 0 <%=length + 110%> <%=height + 80%>">
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
    <svg x="100" y="0" width="<%=length + 1%>" height="<%=height + 4%>" 
         viewBox="0 0 <%=length + 1%> <%=height + 4%>">
    <% out.println(sideDrawing);%>
    </svg>
    <!-- Vertical line -->
    <line x1="70"  y1="0" x2="70" y2="<%=height%>" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="40" y="<%=height / 2%>"
          font-size="15px"
          text-anchor="middle"
          style="writing-mode: tb;">Height: <%=height%></text>
    <!-- Horizontal line %-->
    <line x1="100"  y1="<%=height + 40%>" x2="<%=length + 100%>"   y2="<%=height + 40%>" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="<%=length / 2 + 100%>" y="<%=height + 80%>"
          font-size="15px"
          text-anchor="middle">Width: <%=length%></text>
    </svg>
    <br>
    <br>
    <a href="index.html">Back to index</a>
</body>
</html>
