package modelo;

import java.sql.Date;
import base_datos.AlumnoDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Bruno Tarditi
 */
public class AlumnoModelo {

    private long dni;
    private String nombre;
    private String apellido;
    private Date fecha;
    private String domicilio;
    private String telefono;
    private long insc_cod;
    private AlumnoDAO alumnoDAO = new AlumnoDAO();

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public long getInsc_cod() {
        return insc_cod;
    }

    public void setInsc_cod(long insc_cod) {
        this.insc_cod = insc_cod;
    }

    public ArrayList<String> traeCodInsc() {
        return alumnoDAO.traeCodInscDAO();
    }

    public boolean validaDni(String n) {

        try {
            dni = Long.parseLong(n);
            return false;

        } catch (NumberFormatException e) {
            return true;
        }

    }

    public boolean dniRepetido(AlumnoModelo alumno) {
        return alumnoDAO.dniRepetidoDAO(alumno);
    }

    public boolean validaCarga(String n) {

        if (n.length() == 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean cargaDatos(AlumnoModelo alumno) {

        return alumnoDAO.cargarDatosDAO(alumno);

    }

    public ArrayList<AlumnoModelo> muestraDatos() {
        return alumnoDAO.mostrarAlumnosDAO();
    }

    public boolean modificaDatos(AlumnoModelo alumno) {
        return alumnoDAO.modificaDAO(alumno);
    }

    public boolean bajaDatos(JTable tabla) {

        return alumnoDAO.bajaDAO(tabla);
    }

}
