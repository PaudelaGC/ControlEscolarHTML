<%-- 
    Document   : listar
    Created on : 18 mar 2024, 13:23:58
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
        <h1>Lista de carreras</h1>
        <table>
            <ul>
                <% for (models.Carreras carreras : (java.util.ArrayList<models.Carreras>) request.getAttribute("carreras")){ %>
                <li> <%= carreras.getNombre() %></li>
                <% } %>
                <td><button type="submit" value="${carrera1.getNombre()}">Borrar</button></td>
                <a href="./HomeServlet">Listar carreras</a>
            </ul>
        </table>
    </body>
</html>
