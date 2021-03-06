package entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDomicilio;

    private int numero;
    private String nombreCalle;

    public Domicilio() {
    }

    public Domicilio(long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public long getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
