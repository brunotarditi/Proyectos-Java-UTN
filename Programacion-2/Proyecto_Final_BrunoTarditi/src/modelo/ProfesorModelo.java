package modelo;

import base_datos.ProfesorDAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Bruno Tarditi
 */
public class ProfesorModelo {

    //Atributos de la clase Profesor Modelo
    private long dniProfe;
    private String nombre;
    private String apellido;
    private Date fecha;
    private String domicilio;
    private String telefono;
    private ProfesorDAO profesorDAO = new ProfesorDAO(); //Aquí se asocia la clase profesor Modelo con Profesor DAO

    //Getter y Setters necesarios
    public long getDniProfe() {
        return dniProfe;
    }

    public void setDniProfe(long dniProfe) {
        this.dniProfe = dniProfe;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Valida que el dni sea de numeros
    public boolean validaDni(String n) {

        try {
            dniProfe = Long.parseLong(n);
            return false;

        } catch (NumberFormatException e) {
            return true;
        }

    }

    //Se encarga de que el dni no sea repetido
    public boolean dniRepetido(ProfesorModelo profesor) {
        return profesorDAO.dniRepetidoDAO(profesor);
    }

    //Metodo que valida que se cargue algun dato obligatorio
    public boolean validaCarga(String n) {

        if (n.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //Valida que se carguen los datos que provienen de la base de datos
    public boolean cargaDatos(ProfesorModelo profesor) {

        return profesorDAO.cargarDatosDAO(profesor);

    }

    //Valida que se muestren los datos de la base de datos
    public ArrayList<ProfesorModelo> muestraDatos() {
        return profesorDAO.mostrarProfesoresDAO();
    }

    //Valida que sean modificados los datos de la base de datos
    public boolean modificaDatos(ProfesorModelo profesor) {
        return profesorDAO.modificaDAO(profesor);
    }

    //Valida que se elimine un dato de la base de datos
    public boolean bajaDatos(JTable tabla) {

        return profesorDAO.bajaDAO(tabla);
    }

}
