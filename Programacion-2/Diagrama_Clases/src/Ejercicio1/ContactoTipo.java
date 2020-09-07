package Ejercicio1;

/**
 *
 * @author Bruno Tarditi
 */
public class ContactoTipo {

    //atributos
    private Integer idcontactoTipo;
    private String descripcion;

    //Constructo vacío
    public ContactoTipo() {

    }

    //Constructor sobrecargado
    public ContactoTipo(Integer idcontactoTipo, String descripcion) {
        this.idcontactoTipo = idcontactoTipo;
        this.descripcion = descripcion;
    }

    //Get and Set
    public Integer getIdcontactoTipo() {
        return idcontactoTipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
