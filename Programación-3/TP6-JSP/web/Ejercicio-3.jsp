<%-- 
    Document   : Ejercicio-3
    Created on : 13/10/2020, 13:00:47
    Author     : Bruno Tarditi 
--%>


<%@page import="Modelo.*"%>
<%@page import="java.util.List"%>
<%@page import="controlador.GestorPersona"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Personas</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- Icono -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .derecha{
                text-align: right
            }
            .centrar{
                text-align: center
            }
        </style>
    </head>
    <body>
        <div class="container mt-4">
            <div class="row form-inline">
                <div class="col-sm">

                    <table class="table table-striped text-center">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col" colspan="2" class="centrar">Personas</th>
                            <th scope="col" class="derecha">
                                <a href="Ejercicio-2.jsp" style="color:#FFFFFF">Agregar <i class="fa fa-plus-square fa-lg" style="color:#FFFFFF"></i></a>
                            </th>
                        </tr>
                        </thead>
                        <thead class="thead-light">
                        <tr >
                            <th scope="col">DNI</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Domicilio</th>
                        </tr>
                        </thead>
                        <%
                            GestorPersona gc = new GestorPersona();
                            List<Persona> personas = gc.dameListaPersonas();

                            for (Persona p : personas) {
                        %>
                        <tbody>
                        <tr><td><%out.println(p.getDni());%></td>
                            <td> <%out.println(p.getNombre());%></td>
                            <td><%out.println(p.getDomicilio());%> </td>
                        </tr>
                        </tbody>
                        <%
                    }%>

                    </table>
                </div>
            </div>
        </div>
    </body>
</html>



