<%-- 
    Document   : crear
    Created on : 18 mar 2024, 13:23:48
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear carrera</h1>
        <form action="./CreateServlet" method="post">
            <label for="name">Nombre carrera</label><br>
            <input type="text" name="name">
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
