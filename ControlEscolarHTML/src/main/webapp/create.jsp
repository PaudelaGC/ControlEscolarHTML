<%-- 
    Document   : create.jsp
    Created on : 19 mar 2024, 11:25:57
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear carrera</title>
    </head>
    <body>
        <h1>Crear</h1>
        <form action="./HomeServlet" method="post">
            <label for="carrera">Crear carrera:</label><br>
            <input type="text" id="carrera" name="carrera"><br>
            <input type="submit" value="Aceptar">
        </form>
    </body>
</html>
