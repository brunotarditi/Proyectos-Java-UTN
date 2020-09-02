package modelo;

import base_datos.MateriaDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Bruno Tarditi
 */
public class MateriaModelo {

    private long mat_cod;
    private String mat_nombre;
    private long mat_prof_dni;
    private MateriaDAO materiaDAO = new MateriaDAO();

    public long getMat_cod() {
        return mat_cod;
    }

    public void setMat_cod(long mat_cod) {
        this.mat_cod = mat_cod;
    }

    public String getMat_nombre() {
        return mat_nombre;
    }

    public void setMat_nombre(String mat_nombre) {
        this.mat_nombre = mat_nombre;
    }

    public long getMat_prof_dni() {
        return mat_prof_dni;
    }

    public void setMat_prof_dni(long mat_prof_dni) {
        this.mat_prof_dni = mat_prof_dni;
    }

    public ArrayList<String> matDniProf() {
        return materiaDAO.muestraDniProf();
    }

    public boolean validaCarga(String n) {

        if (n.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    


    public boolean cargaDatos(MateriaModelo materia) {

        return materiaDAO.cargarDatosDAO(materia);

    }

    public ArrayList<MateriaModelo> muestraDatos() {
        return materiaDAO.mostrarMateriasDAO();
    }

    public boolean modificaDatos(MateriaModelo materia) {
        return materiaDAO.modificaDAO(materia);
    }

    public boolean bajaDatos(JTable tabla) {

        return materiaDAO.bajaDAO(tabla);
    }

}
