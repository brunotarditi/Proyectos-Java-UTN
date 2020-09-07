package Ejercicio1;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Persona {

    //atributos
    private String nombre;
    private String apellido;
    private Integer idPersona;

    //Constructor vacío
    public Persona() {

    }

    //Constructos sobrecargado
    public Persona(String nombre, String apellido, Integer idPersona) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idPersona = idPersona;
    }

    //Set and Get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

}
