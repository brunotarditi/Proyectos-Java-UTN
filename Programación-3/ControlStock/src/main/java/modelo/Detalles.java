package modelo;

import datos.ProductoDao;

import java.util.List;

public class Detalles {

    private int idDetalles;
    private int saldoCantidad;
    private int entradaCantidad;
    private int salidaCantidad;
    private double saldoCosto;
    private double entradaCosto;
    private double salidaCosto;
    private String detalle;
    private int idProducto;
    private String existencias;

    public Detalles() {
    }

    public Detalles(int idProducto) {
        this.idProducto = idProducto;
    }

    public Detalles(int idDetalles, int saldoCantidad, int entradaCantidad, int salidaCantidad, double saldoCosto, double entradaCosto, double salidaCosto, String detalle , int idProducto, String existencias) {
        this.idDetalles = idDetalles;
        this.saldoCantidad = saldoCantidad;
        this.entradaCantidad = entradaCantidad;
        this.salidaCantidad = salidaCantidad;
        this.saldoCosto = saldoCosto;
        this.entradaCosto = entradaCosto;
        this.salidaCosto = salidaCosto;
        this.detalle = detalle;
        this.idProducto = idProducto;
        this.existencias = existencias;
    }

    public Detalles(int saldoCantidad, int entradaCantidad, int salidaCantidad, double saldoCosto, double entradaCosto, double salidaCosto,String detalle, int idProducto, String existencias) {
        this.saldoCantidad = saldoCantidad;
        this.entradaCantidad = entradaCantidad;
        this.salidaCantidad = salidaCantidad;
        this.saldoCosto = saldoCosto;
        this.entradaCosto = entradaCosto;
        this.salidaCosto = salidaCosto;
        this.detalle = detalle;
        this.idProducto = idProducto;
        this.existencias = existencias;
    }

    public int getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(int idDetalles) {
        this.idDetalles = idDetalles;
    }

    public int getSaldoCantidad() {
        return saldoCantidad;
    }

    public void setSaldoCantidad(int saldoCantidad) {
        this.saldoCantidad = saldoCantidad;
    }

    public int getEntradaCantidad() {
        return entradaCantidad;
    }

    public void setEntradaCantidad(int entradaCantidad) {
        this.entradaCantidad = entradaCantidad;
    }

    public int getSalidaCantidad() {
        return salidaCantidad;
    }

    public void setSalidaCantidad(int salidaCantidad) {
        this.salidaCantidad = salidaCantidad;
    }

    public double getSaldoCosto() {
        return saldoCosto;
    }

    public void setSaldoCosto(double saldoCosto) {
        this.saldoCosto = saldoCosto;
    }

    public double getEntradaCosto() {
        return entradaCosto;
    }

    public void setEntradaCosto(double entradaCosto) {
        this.entradaCosto = entradaCosto;
    }

    public double getSalidaCosto() {
        return salidaCosto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setSalidaCosto(double salidaCosto) {
        this.salidaCosto = salidaCosto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "Detalles{" +
                "idDetalles=" + idDetalles +
                ", saldoCantidad=" + saldoCantidad +
                ", entradaCantidad=" + entradaCantidad +
                ", salidaCantidad=" + salidaCantidad +
                ", saldoCosto=" + saldoCosto +
                ", entradaCosto=" + entradaCosto +
                ", salidaCosto=" + salidaCosto +
                ", detalle='" + detalle + '\'' +
                ", idProducto=" + idProducto +
                ", existencias='" + existencias + '\'' +
                '}';
    }

}

