package modelo;

import datos.DetallesDao;
import datos.ProductoDao;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private int idProducto;
    private String nombre;
    private List<Detalles> detallesList = new ArrayList<>();

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(int idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Detalles> getDetallesList() {
        return detallesList;
    }

    public void setDetallesList(List<Detalles> detallesList) {
        this.detallesList = detallesList;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", detallesList=" + detallesList +
                '}';
    }

    public double getSaldoTotal(){
        double totales = 0;
        this.detallesList = new DetallesDao().getAllDetails(new Detalles(this.idProducto));
        for (Detalles d : this.detallesList) {
            totales = d.getSaldoCosto();
        }
        return totales;
    }

    public int getCantidad(){
        int cantidades = 0;
        this.detallesList = new DetallesDao().getAllDetails(new Detalles(this.idProducto));
        for (Detalles d : this.detallesList) {
            cantidades = d.getSaldoCantidad();
        }
        return cantidades;
    }

}
