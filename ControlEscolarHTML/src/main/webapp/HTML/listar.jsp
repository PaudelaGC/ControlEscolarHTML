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
                    <form action="./ModifyServlet" method="get">
                        <input type="hidden" name="modify" value="<%= carreras.getNombre() %>" />
                        <button type="submit" >Modificar</button>
                    </form>
                </td>
                
                <td>    
                    <form action="./DeleteServlet" method="post">
                        <input type="hidden" name="borrar" value="<%= carreras.getNombre() %>" />
                        <button type="submit" >Borrar</button>
                    </form>
                </td>
               
            <% } %>
            </tr>
        </table>
        <a href="./HomeServlet">Volver</a>
    </body>
</html>
