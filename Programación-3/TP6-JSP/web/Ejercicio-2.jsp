<%-- 
    Document   : Ejercicio-2
    Created on : 12/10/2020, 21:41:49
    Author     : Bruno Tarditi 
--%>

<%@page import="controlador.GestorPersona"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="conexionBD.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar Persona</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

        <div class="container mt-5">
            <div class="row align-items-center justify-content-center">
                <div class="col-sm-6">

                    <form action="Ejercicio-2.jsp">
                        <div class="form-group">
                            <label for="dni">DNI: </label>
                            <input type="text" class="form-control" required="required" name="dni" id="dni" placeholder="dni">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre: </label>
                            <input type="text" class="form-control" required="required" name="nombre" id="nombre" placeholder="Nombre">
                        </div>
                        <div class="form-group">
                            <label for="domicilio">Domicilio: </label>
                            <input type="text" class="form-control" required="required" name="domicilio" id="domicilio" placeholder="domicilio">
                        </div>    
                        <button type="submit" class="btn btn-primary" name="enviar">Enviar</button>
                    </form>
                </div> 
            </div> 
        </div> 
    </body>
</html>

<%

    if (request.getParameter("enviar") != null) {
        long dni = Long.parseLong(request.getParameter("dni"));
        String nombre = request.getParameter("nombre");
        String domicilio = request.getParameter("domicilio");
        GestorPersona gc = new GestorPersona();
        gc.insertarPersona(dni, nombre, domicilio);
        request.getRequestDispatcher("Ejercicio-3.jsp").forward(request, response);
    }
%>



