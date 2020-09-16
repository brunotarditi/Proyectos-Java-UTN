package modelo;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Bruno Tarditi
 */
public class Empleado extends Persona implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    //private int idEmpleado;
    private int nroLegajo;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(int nroLegajo, double sueldo, String nombre, String apellido, long dni, Domicilio domicilio) {
        super(nombre, apellido, dni, domicilio);
        this.nroLegajo = nroLegajo;
        this.sueldo = sueldo;
    }

//    public int getIdEmpleado() {
//        return idEmpleado;
//    }
//
//    public void setIdEmpleado(int idEmpleado) {
//        this.idEmpleado = idEmpleado;
//    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDomicilio")
    @Override
    public Domicilio getDomicilio() {
        return this.domicilio;
    }

    @Override
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
