<%-- 
    Document   : confirmationPage
    Created on : 16-11-2017, 09:56:25
    Author     : Christian Kolz Barth
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int length = (int) session.getAttribute("length");
    int width = (int) session.getAttribute("width");
    int height = (int) session.getAttribute("height");
    String sideDrawing = (String) session.getAttribute("drawingfromside");
    String topDrawing = (String) session.getAttribute("drawingfromtop");
    User user = (User) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>confirmationPage</title>
    </head>

    <body>
        <h1>Vi modtog dine oplysninger. Herunder kan du se din valgte carport <% out.print(user.getEmail()); %> . </h1>
        <br>
        <h1>Top Carport tegning</h1>
        <svg width="50%" 
             viewBox="0 0 <%=length + 110%> <%=width + 80%>">
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
    <svg x="100" y="0" width="<%=length + 1%>" height="<%=width + 4%>" 
         viewBox="0 0 <%=length + 1%> <%=width + 4%>">
    <% out.println(topDrawing);%>
    </svg>
    <!-- Vertical line -->
    <line x1="70"  y1="0" x2="70" y2="<%=width%>" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="40" y="<%=width / 2%>"
          font-size="15px"
          text-anchor="middle"
          style="writing-mode: tb;">Width: <%=width%></text>
    <!-- Horizontal line %-->
    <line x1="100"  y1="<%=width + 40%>" x2="<%=length + 90%>"   y2="<%=width + 40%>" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="<%=length / 2 + 100%>" y="<%=width + 80%>"
          font-size="15px"
          text-anchor="middle">Length: <%=length%></text>
    </svg>
    <br>
    <h1>Side Carport tegning</h1>
    <svg width="50%" 
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
          text-anchor="middle">Length: <%=length%></text>
    </svg>
    <br>
    <br>
    <form name="confirmordernow" action="ConfirmOrderServlet" method="POST">
        Er du sikker på dit køb?:
        <br><br>
        <button type="submit" name="action" value="confirmorder">Submit</button>
    </form>
    <br>
    <br>
    <a href="customerpage.jsp">Nej det er jeg ikke. Jeg vil godt tilbage til min customerpage.</a>
</body>
</html>
