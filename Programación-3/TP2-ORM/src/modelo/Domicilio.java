package modelo;

import javax.persistence.Entity;

/**
 *
 * @author Bruno Tarditi
 */
@Entity
public class Domicilio extends EntityBean implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    //private int idDomicilio;
    private String localidad;
    private String calle;
    private int numero;
    private Persona persona;

    public Domicilio() {
    }

    public Domicilio( String localidad, String calle, int numero, Persona persona) {
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
        this.persona = persona;
    }

//    public int getIdDomicilio() {
//        return idDomicilio;
//    }
//
//    public void setIdDomicilio(int idDomicilio) {
//        this.idDomicilio = idDomicilio;
//    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
