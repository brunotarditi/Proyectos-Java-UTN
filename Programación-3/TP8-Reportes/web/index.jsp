<%-- 
    Document   : index
    Created on : 03/11/2020, 02:34:38
    Author     : Bruno Tarditi 
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Country"%>
<%@page import="controlador.GestorCountry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body><div class="row mt-5 justify-content-center">
            <div class="col-3 px-4 py-4" style="background-color: #A8CADA">
                <form>
                    <div class="form-group">
                        <label>País:</label>
                        <input type="text" class="form-control" name="pais" id="pais"/>
                    </div>
                    <div class="form-group">
                        <label>Regiones:</label>
                        <%GestorCountry gc = new GestorCountry();
                            List<Country> countrys = gc.dameListaPaises();
                        %><select class="form-control" name="region" id="region">
                            <option value=""></option>  <%
                                for (Country c : countrys) {
                            %>
                            <option><%out.println(c.getRegion());%></option>
                            <% }%>
                        </select>
                    </div>
                    <div class="text-center">
                        <button class="btn btn-danger" type="submit" name="pdf" formaction="generarPDF.jsp">Generar PDF</button>
                        <button type="submit" class="btn btn-success" name="excel" formaction="generarExcel.jsp">Generar Excel</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

