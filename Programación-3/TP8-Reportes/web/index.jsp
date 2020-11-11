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
    </head>
    <body>
        <form action="generarPDF.jsp" method="POST">
            <label>País:</label>
            <input type="text" name="pais" id="pais"/>
            <label>Regiones:</label>
            <%GestorCountry gc = new GestorCountry();
                List<Country> countrys = gc.dameListaPaises();
                %><select name="region" id="region"><%
                for (Country c : countrys) {
                %>
                <option><%out.println(c.getRegion());%></option>
                <% }%>
            </select>         
            <button type="submit" name="pdf" >Generar PDF</button>
            <button type="submit" name="excel" >Generar Excel</button>
        </form>
    </body>
</html>

