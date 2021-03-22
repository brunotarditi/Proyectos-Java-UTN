<%--
  User: bruno
  Date: 15/2/2021
  Time: 23:26
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>
<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" %>

<section id="detalles">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header">
                        <h4>Método PEPS</h4>
                    </div>
                    <table class=" table table-hover">
                        <thead>
                        <tr>
                            <th>Detalle</th>
                            <th>Entrada</th>
                            <th>Salida</th>
                            <th>Cantidad</th>
                            <th>Entrada</th>
                            <th>Salida</th>
                            <th>Total</th>
                            <th>Existencias</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="detalle" items="${detalles}" varStatus="status">
                            <tr>
                                <td>${detalle.detalle}</td>
                                <td>${detalle.entradaCantidad}</td>
                                <td>${detalle.salidaCantidad}</td>
                                <td>${detalle.saldoCantidad}</td>
                                <td><fmt:formatNumber value="${detalle.entradaCosto}" type="currency"/></td>
                                <td><fmt:formatNumber value="${detalle.salidaCosto}" type="currency"/></td>
                                <td><fmt:formatNumber value="${detalle.saldoCosto}" type="currency"/></td>
                                <td colspan="2">${detalle.existencias}</td>
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
<jsp:include page="/WEB-INF/paginas/detalles/agregarCompra.jsp" />
<jsp:include page="/WEB-INF/paginas/detalles/agregarVenta.jsp" />
