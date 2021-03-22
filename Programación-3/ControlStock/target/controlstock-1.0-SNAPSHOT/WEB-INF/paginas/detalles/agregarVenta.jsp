<%--
  User: bruno
  Date: 16/2/2021
  Time: 20:52
--%>
<div class="modal fade" id="agregarVentaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar venta</h5>
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=vender&idProducto=${idProducto}" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="cantidad">Cantidad</label>
                        <input type="number" class="form-control" name="cantidad" id="cantidad"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-danger" type="submit">Vender</button>
                </div>
            </form>
        </div>
    </div>
</div>
