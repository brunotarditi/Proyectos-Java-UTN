package Ejercicio2;

/**
 *
 * @author Bruno Tarditi
 */
public class Producto {

    //atributos
    private int codigo;
    private String descripcion;
    private float precio;

    //Constructor vacío
    public Producto() {

    }

    //Constructor sobrecargado
    public Producto(int codigo, String descripcion, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //get and set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
