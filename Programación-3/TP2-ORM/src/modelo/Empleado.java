package modelo;

/**
 *
 * @author Bruno Tarditi
 */
public class Empleado extends Persona implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int idEmpleado;
    private int nroLegajo;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(int idEmpleado, int nroLegajo, double sueldo, int idPersona, String nombre, String apellido, long dni, Domicilio domicilio) {
        super(idPersona, nombre, apellido, dni, domicilio);
        this.idEmpleado = idEmpleado;
        this.nroLegajo = nroLegajo;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
