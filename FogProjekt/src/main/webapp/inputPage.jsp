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
        <h2>Det hele foregår i cm.</h2>
        <br>
        Indtast dine ønskede mål i felterne nedenfor.
        <form name="buildcarport" action="InputServlet" method="POST">
            <input type="hidden" name="action" value="build">
            <br>
            Længde i cm: <input type="text" name="length" value="" placeholder="Maks 999"/> 
            <br>
            Bredde i cm: <input type="text" name="width" value="" placeholder="Maks 999"/>
            <br>
            Højde i cm:  <input type="text" name="height" value="" placeholder="Maks 999"/>
            <br>
            <br>
            <input type="submit" value="BuildCarport"/>
        </form>
    </body>
</html>
