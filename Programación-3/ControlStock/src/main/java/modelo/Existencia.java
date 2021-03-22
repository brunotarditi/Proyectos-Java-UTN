package modelo;

public class Existencia {
    private int idExistencia;
    private int cantidad;
    private double precioCosto;
    private int idProducto;

    public Existencia() {
    }

    public Existencia(int idExistencia, int cantidad, double precioCosto, int idProducto) {
        this.idExistencia = idExistencia;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.idProducto = idProducto;
    }

    public Existencia(int cantidad, double precioCosto, int idProducto) {
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.idProducto = idProducto;
    }

    public Existencia(int id) {
        this.idProducto = id;
        this.idExistencia = id;
    }


    public int getIdExistencia() {
        return idExistencia;
    }

    public void setIdExistencia(int idExistencia) {
        this.idExistencia = idExistencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
