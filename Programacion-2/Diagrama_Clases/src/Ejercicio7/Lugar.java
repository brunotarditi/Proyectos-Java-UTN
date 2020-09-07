package Ejercicio7;

/**
 *
 * @author Bruno Tarditi
 */
public class Lugar {

    private String nombre;
    private Direccion direccion;

    public Lugar() {

    }

    public Lugar(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
