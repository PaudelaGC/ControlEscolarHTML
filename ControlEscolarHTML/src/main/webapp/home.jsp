<%-- 
    Document   : home
    Created on : 18 mar 2024, 12:57:01
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
        <h1>Administrador de carreras</h1>
        <table>
            <tr>
                <td><a href="./CreateServlet" >Crear carrera</a></td>                
            </tr>
            <tr>
                <td><a href="./ListarServlet">Listar carreras</a></td>
            </tr>
        </table>     
        <p style="display:<%= request.getAttribute("display")%>"><%= request.getAttribute("content")%></p>
    </body>
</html>
