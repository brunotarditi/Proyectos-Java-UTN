<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 16/2/2021
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" %>
<div class="modal fade" id="agregarCompraModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar compra</h5>
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=comprar&idProducto=${idProducto}" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="cantidad">Cantidad</label>
                        <input type="number" class="form-control" name="cantidad" id="cantidad"/>
                    </div>
                    <div class="form-group">
                        <label for="precioCosto">Precio Costo</label>
                        <input type="number" step="any" class="form-control" name="precioCosto" id="precioCosto"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Comprar</button>
                </div>
            </form>
        </div>
    </div>
</div>

