<%--
  User: bruno
  Date: 15/2/2021
  Time: 23:33
--%>
<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" %>
<div class="modal fade" id="agregarProductoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar producto</h5>
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="nombre"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>

