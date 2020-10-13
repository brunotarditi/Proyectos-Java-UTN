package Modelo;

/**
 *
 * @author Bruno Tarditi
 */
public class Persona {
    
    private long dni;
    private String nombre;
    private String domicilio;
    

    public Persona() {
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
   
}
