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
        <h1>Lista de carreras</h1>
        <table>
            
            <% for (Carreras carreras : (ArrayList<Carreras>) request.getAttribute("carreras")){ %>
            <tr>
                <td> 
                    <%= carreras.getNombre() %>
                </td>
                
                <td>
                    <button type="submit" value="<%= carreras.getNombre() %>">Borrar</button>
                </td>
               
            <% } %>
            </tr>
        </table>
        <a href="./HomeServlet">Volver</a>
    </body>
</html>
