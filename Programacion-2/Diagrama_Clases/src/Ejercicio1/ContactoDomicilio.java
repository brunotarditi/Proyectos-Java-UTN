package Ejercicio1;

/**
 *
 * @author Bruno Tarditi
 */
public class ContactoDomicilio {

    //atributos
    private Integer idContactoDomicilio;
    private String descripcion;

    //Constructor vacío
    public ContactoDomicilio() {

    }

    //Constructor sobrecargado
    public ContactoDomicilio(Integer idContactoDomicilio, String descripcion) {
        this.idContactoDomicilio = idContactoDomicilio;
        this.descripcion = descripcion;
    }

    //Get and Set
    public Integer getIdContactoDomicilio() {
        return idContactoDomicilio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
