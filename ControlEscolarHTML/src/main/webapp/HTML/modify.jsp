<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Carreras" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar carrera</h1>
        <p>Vas a modificar: <%= request.getAttribute("oldName") %></p>
        <form action="./ModifyServlet" method="post">
            <input type="text" name="name">
            <input type="submit" value="Send">
        </form>
        <a href="./ListarServlet">Volver</a>
    </body>
</html>
