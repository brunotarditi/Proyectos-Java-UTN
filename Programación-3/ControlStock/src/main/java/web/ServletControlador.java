package web;

import datos.DetallesDao;
import datos.ExistenciaDao;
import datos.ProductoDao;
import modelo.Detalles;
import modelo.Existencia;
import modelo.Producto;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    public static int ID_PRODUCTO = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "detalles":
                    int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    this.accionDefaultDetails(request, response, idProducto);
                    break;
                case "eliminar":
                    this.eliminar(request, response);
                    break;
                default:
                    this.accionDefaultProducts(request, response);
            }
        } else {
            this.accionDefaultProducts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProducto(request, response);
                    break;
                case "comprar":
                    this.insertarDetalle(request, response);
                    break;
                case "vender":
                    this.venderDetalle(request, response);
                    break;
                default:
                    this.accionDefaultProducts(request, response);
            }
        } else {
            this.accionDefaultProducts(request, response);
        }
    }

    private void accionDefaultProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> productos = new ProductoDao().getAllProducts();
        System.out.println(productos);
        HttpSession session = request.getSession();
        session.setAttribute("productos", productos);
        //session.setAttribute("saldoTotal", saldoTotal(productos));
        //request.getRequestDispatcher("productos.jsp").forward(request, response);
        response.sendRedirect("productos.jsp");
    }

    private void accionDefaultDetails(HttpServletRequest request, HttpServletResponse response, int idProducto) throws ServletException, IOException {
        Detalles detalle = new Detalles(idProducto);
        List<Detalles> detalles = new DetallesDao().getAllDetails(detalle);
        System.out.println(detalles);
        HttpSession session = request.getSession();
        session.setAttribute("detalles", detalles);
        session.setAttribute("idProducto", idProducto);
        //request.getRequestDispatcher("detalles.jsp").forward(request, response);
        response.sendRedirect("detalles.jsp");
    }

    private void insertarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los valores del formulario agregarProducto
        String nombre = request.getParameter("nombre");

        //Creamos el objeto de cliente (modelo)
        Producto producto = new Producto(nombre);

        //Insertamos en la base de datos
        int registrosModificados = new ProductoDao().insert(producto);
        System.out.println(registrosModificados);

        //Redirijimos hacia la accion por default
        this.accionDefaultProducts(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //recuperamos los valores del formulario editarCliente
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));

        //Creamos el objeto de cliente (modelo)
        Producto producto = new Producto(idProducto);

        //Eliminamos en la base de datos
        int registrosModificados = new ProductoDao().delete(producto);
        System.out.println(registrosModificados);

        //Redirijimos hacia la accion por default
        this.accionDefaultProducts(request, response);
    }

    private void insertarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCompra
        int idProducto = 0;
        String idProductoString = request.getParameter("idProducto");
        if (idProductoString != null && !idProductoString.equals("")) {
            idProducto = Integer.parseInt(idProductoString);
            System.out.println(idProducto);
        }
        int cantidad = 0;
        String cantidadString = request.getParameter("cantidad");
        if (cantidadString != null && !cantidadString.equals("")) {
            cantidad = Integer.parseInt(cantidadString);
        }
        double precio = 0;
        String precioString = request.getParameter("precioCosto");
        if (precioString != null && !precioString.equals("")) {
            precio = Double.parseDouble(precioString);
        }

        Existencia existencia = new Existencia(idProducto);
        List<Existencia> existencias = new ExistenciaDao().getAllStocks(existencia);

        Detalles detalle = new Detalles(idProducto);
        List<Detalles> detalles = new DetallesDao().getAllDetails(detalle);

        int sumatoriaCantidad = cantidad;
        double saldoCosto = 0;
        double costoEntrada = 0;
        costoEntrada = cantidad * precio;
        sumatoriaCantidad += saldoCantidad(detalles);
        saldoCosto = costoEntrada + saldoCosto(detalles);


        String e = cantidad + " u. a $" + precio;

        //Creamos el objeto de cliente (modelo)
        detalle = new Detalles(sumatoriaCantidad, cantidad, 0, saldoCosto, costoEntrada, 0, "Compra", idProducto, e);
        existencia = new Existencia(cantidad, precio, idProducto);

        //Insertamos en la base de datos
        int existenciasInsertadas = new ExistenciaDao().insert(existencia);
        int detallesInsertados = new DetallesDao().insert(detalle);
        System.out.println(detallesInsertados);
        System.out.println(existenciasInsertadas);

        //Redirijimos hacia la accion por default
        this.accionDefaultDetails(request, response, idProducto);
    }

    private void venderDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCompra
        int idProducto = 0;
        String idProductoString = request.getParameter("idProducto");
        if (idProductoString != null && !idProductoString.equals("")) {
            idProducto = Integer.parseInt(idProductoString);
            System.out.println(idProducto);
        }

        int cantidad = 0;
        String cantidadString = request.getParameter("cantidad");
        if (cantidadString != null && !cantidadString.equals("")) {
            cantidad = Integer.parseInt(cantidadString);
        }


        Existencia existencia = new Existencia(idProducto);
        List<Existencia> existencias = new ExistenciaDao().getAllStocks(existencia);
        Detalles detalle = new Detalles(idProducto);
        List<Detalles> detalles = new DetallesDao().getAllDetails(detalle);
        int cantidadTotal = saldoCantidad(detalles);
        double costoSalida = 0;
        double saldoTotal = saldoCosto(detalles);
        for (Existencia e : existencias) {

            String existenciaDetalle = "";

            if (cantidad < e.getCantidad()) {
                cantidadTotal -= cantidad;
                costoSalida = cantidad * e.getPrecioCosto();
                saldoTotal -= costoSalida;
                existenciaDetalle = e.getCantidad() + " u. a $" + e.getPrecioCosto();
                detalle = new Detalles(cantidadTotal, 0, cantidad, saldoTotal, 0, e.getPrecioCosto(), "Venta", idProducto, existenciaDetalle);
                cantidad = e.getCantidad() - cantidad;
                existencia = new Existencia(e.getIdExistencia(), cantidad, e.getPrecioCosto(), idProducto);

                int registroActualizado = new ExistenciaDao().update(existencia);
                int registroInsertado = new DetallesDao().insert(detalle);
                System.out.println("actualizado en Existencias");
                System.out.println("Venta insertada en detalles");
                break;
            } else if (cantidad > e.getCantidad()) {
                cantidad -= e.getCantidad();
                cantidadTotal -= e.getCantidad();
                costoSalida = e.getCantidad() * e.getPrecioCosto();
                saldoTotal -= costoSalida;
                existenciaDetalle = e.getCantidad() + " u. a $" + e.getPrecioCosto();
                detalle = new Detalles(cantidadTotal, 0, e.getCantidad(), saldoTotal, 0, e.getPrecioCosto(), "Venta", idProducto, existenciaDetalle);
                int registroInsertado = new DetallesDao().insert(detalle);
                existencia = new Existencia(e.getIdExistencia());
                int registroEliminador = new ExistenciaDao().delete(existencia);
                System.out.println("eliminado en Existencias");
                System.out.println("Venta insertada en detalles");
            } else if (cantidad == e.getCantidad()) {
                cantidadTotal -= e.getCantidad();
                costoSalida = e.getCantidad() * e.getPrecioCosto();
                saldoTotal -= costoSalida;
                existenciaDetalle = e.getCantidad() + " u. a $" + e.getPrecioCosto();
                detalle = new Detalles(cantidadTotal, 0, e.getCantidad(), saldoTotal, 0, e.getPrecioCosto(), "Venta", idProducto, existenciaDetalle);
                int registroInsertado = new DetallesDao().insert(detalle);
                existencia = new Existencia(e.getIdExistencia());
                int registroEliminador = new ExistenciaDao().delete(existencia);
                System.out.println("eliminado en Existencias");
                System.out.println("Venta insertada en detalles");
            }

        }

        //Redirijimos hacia la accion por default
        this.accionDefaultDetails(request, response, idProducto);
    }

    private double saldoCosto(List<Detalles> detallesList) {
        double saldoTotal = 0;
        for (Detalles detalles : detallesList) {
            saldoTotal = detalles.getSaldoCosto();
        }
        return saldoTotal;
    }

    private int saldoCantidad(List<Detalles> detallesList) {
        int sumatoriaCantidad = 0;
        for (Detalles detalle : detallesList) {
            sumatoriaCantidad = detalle.getSaldoCantidad();
        }

        return sumatoriaCantidad;
    }

}

