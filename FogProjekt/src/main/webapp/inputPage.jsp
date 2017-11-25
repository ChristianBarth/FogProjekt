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
        Indtast dine ønskede mål i felterne nedenfor.
        <form name="buildcarport" action="InputServlet" method="POST">
            <input type="hidden" name="action" value="build">
            <br>
            Længde i cm: <input type="text" name="length" value="" placeholder="Mål foregår i cm"/> 
            <br>
            Bredde i cm: <input type="text" name="width" value="" placeholder="Mål foregår i cm"/>
            <br>
            Højde i cm:  <input type="text" name="height" value="" placeholder="Mål foregår i cm"/>
            <br>
            <br>
            <input type="submit" value="BuildCarport"/>
        </form>
    </body>
</html>
