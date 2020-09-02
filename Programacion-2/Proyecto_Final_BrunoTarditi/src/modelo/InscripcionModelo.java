package modelo;

import java.sql.Date;
import base_datos.InscripcionDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Bruno Tarditi
 */
public class InscripcionModelo {
    
    private long insc_cod;
    private String insc_nombre;
    private Date insc_fecha;
    private long insc_car_cod;
    private InscripcionDAO inscDAO = new InscripcionDAO();

    public long getInsc_cod() {
        return insc_cod;
    }

    public void setInsc_cod(long insc_cod) {
        this.insc_cod = insc_cod;
    }

    public String getInsc_nombre() {
        return insc_nombre;
    }

    public void setInsc_nombre(String insc_nombre) {
        this.insc_nombre = insc_nombre;
    }

    public Date getInsc_fecha() {
        return insc_fecha;
    }

    public void setInsc_fecha(Date insc_fecha) {
        this.insc_fecha = insc_fecha;
    }

    public long getInsc_car_cod() {
        return insc_car_cod;
    }

    public void setInsc_car_cod(long insc_car_cod) {
        this.insc_car_cod = insc_car_cod;
    }
    
    
    public boolean validaCarga(String a) {  
        if (a.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<String> RetornaInscCarCod(){
        return inscDAO.RetornaInscCarCodDAO();
    }

    public boolean cargaDatos(InscripcionModelo inscripcion) {

        return inscDAO.cargarDatosDAO(inscripcion);

    }

    public ArrayList<InscripcionModelo> muestraDatos() {
        return inscDAO.mostrarInscripcionesDAO();
    }

    public boolean modificaDatos(InscripcionModelo inscripcion) {
        return inscDAO.modificaDAO(inscripcion);
    }

    public boolean bajaDatos(JTable tabla) {

        return inscDAO.bajaDAO(tabla);
    }
    
    
}
