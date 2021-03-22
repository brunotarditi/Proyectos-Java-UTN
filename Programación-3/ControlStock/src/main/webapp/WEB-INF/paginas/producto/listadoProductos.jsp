<%--
  User: bruno
  Date: 4/2/2021
  Time: 10:04
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>
<section id="productos">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Productos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                            <th>Detalles</th>
                            <th>Eliminar</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="producto" items="${productos}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${producto.nombre}</td>
                                <td>${producto.cantidad}</td>
                                <td><fmt:formatNumber value="${producto.saldoTotal}" type="currency"/></td>
                                <td><a href="${pageContext.request.contextPath}/ServletControlador?accion=detalles&idProducto=${producto.idProducto}" class="btn btn-success">
                                    <i class="fas fa-arrow-alt-circle-right"></i> Detalles
                                </a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idProducto=${producto.idProducto}" class="btn btn-danger">
                                        <i class="fas fa-trash"></i> Eliminar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>
    </div>
</section>

<!-- Modal agregar cliente -->
<jsp:include page="/WEB-INF/paginas/producto/agregarProducto.jsp" />