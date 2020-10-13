<%-- 
    Document   : index
    Created on : 12/10/2020, 01:05:20
    Author     : Bruno Tarditi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página 1</title>
        <style> 
            .boton{

                text-decoration: none;
                padding: 5px;
                font-weight: 400;
                font-size: 17px;
                background-color: #0E8EDF;
                color: #ffffff;
                border-radius: 2px;
                border: 2px solid #5F034E;
            }
            .boton:hover{
                color: #0E8EDF;
                background-color: #ffffff;
            }
        </style>


    </head>
    <body>
        <form action="pagina2.jsp" id="formulario" name="formulario">
            <table align="center">
                <tr>
                    <td style="font-size: 18px">Ingrese fila:</td>
                    <td><input type="text" name="fila" id="fila" /></td>
                </tr>
                <tr>
                    <td style="font-size: 18px">Ingrese columna:</td>
                    <td><input type=text name="columna" id="columna" /></td>
                </tr>

                <tr>

                    <td colspan="2" align="center" ><br><button type="submit" class="boton">ENVIAR</button></td>
                </tr> 

            </table>
        </form>

    </body>

    <!-- Este script es para que no se envie el formulario si no indica fila o columna -->
    <script>


        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("formulario").addEventListener('submit', validarFormulario);
        });

        function validarFormulario(evento) {
            evento.preventDefault();<!-- Se detiene el evento submit con preventDefault-->
            var row = parseInt(document.getElementById('fila').value);
            if (!Number.isInteger(row)) {
                alert('Ingrese un número para la fila.');
                return;
            }
            var column = parseInt(document.getElementById('columna').value);
            if (!Number.isInteger(column)) {
                alert('Ingrese un número para la columna.');
                return;
            }

            this.submit();
        }

    </script>



</html>




