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
            <tr>
                <td>${carrera1.getNombre()}</td>
                <td><button>Borrar</button></td>
            </tr>
        </table>
    </body>
</html>
