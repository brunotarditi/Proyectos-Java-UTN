<%-- 
    Document   : pagina2
    Created on : 12/10/2020, 01:09:46
    Author     : Bruno Tarditi 
--%>


<%@page import="org.apache.jasper.JasperException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página 2</title>
        <style>
            .tabla{
                margin: auto;
                width: 50%;
                border-color: black;
            }
            
        </style>



    </head>

    <body>
        <table class="tabla" border="1px">
            <%

                if (request.getParameter("fila") != null && request.getParameter("columna") != null) {

                    int fila = Integer.parseInt(request.getParameter("fila"));
                    int columna = Integer.parseInt(request.getParameter("columna"));

                    for (int i = 1; i <= fila; i++) {
                        out.print("<tr>");
                        for (int j = 1; j <= columna; j++) {
                            out.print("<td>" + i + "." + j + "</td>");
                            
                        }
                        out.print("</tr>");
                    }

                }
            %>

        </table>

    </body>
</html>
