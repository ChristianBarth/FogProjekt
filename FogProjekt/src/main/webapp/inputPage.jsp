<%-- 
    Document   : inputPage
    Created on : 15-11-2017, 13:36:15
    Author     : Christian Kolz Barth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InputPage</title>
    </head>
    <body>
        <h1>Byg din egen carport</h1>
        <br>
        <form action="InputServlet" method="POST">
            Indtast dine ønskede mål i felterne nedenfor.
            <br><br>
            Længde i mm:
            <br>
            <input type="text" name="length" value="" placeholder="Fx. 8000"/> 
            <br><br>
            Bredde i mm:
            <br>
            <input type="text" name="width" value="" placeholder="Fx. 6000"/>
            <br><br>
            Højde i mm:
            <br>
            <input type="text" name="height" value="" placeholder="Fx. 2500"/>
            <br><br>
            <input type="submit" value="Byg carport" name="BuildButton"/>
            <input type="hidden" name="action" value="build"/>
        </form>
    </body>
</html>
