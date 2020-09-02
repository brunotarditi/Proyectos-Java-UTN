package modelo;

import base_datos.CursadoDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Bruno Tarditi
 */
public class CursadoModelo {

    private long cur_alu_dni;
    private long cur_mat_cod;
    private int cur_nota;
    private CursadoDAO cursadoDAO = new CursadoDAO();

    public long getCur_alu_dni() {
        return cur_alu_dni;
    }

    public void setCur_alu_dni(long cur_alu_dni) {
        this.cur_alu_dni = cur_alu_dni;
    }

    public long getCur_mat_cod() {
        return cur_mat_cod;
    }

    public void setCur_mat_cod(long cur_mat_cod) {
        this.cur_mat_cod = cur_mat_cod;
    }

    public int getCur_nota() {
        return cur_nota;
    }

    public void setCur_nota(int cur_nota) {
        this.cur_nota = cur_nota;
    }

    public ArrayList<String> retornaAluDNI() {
        return cursadoDAO.claveAluDniDAO();
    }

    public ArrayList<String> retornaMatCod() {
        return cursadoDAO.claveMatCodDAO();
    }

    public boolean validaCarga(String n) {

        if (n.length() == 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean cargaDatos(CursadoModelo cursado) {

        return cursadoDAO.cargarDatosDAO(cursado);

    }

    public ArrayList<CursadoModelo> muestraDatos() {
        return cursadoDAO.mostrarCursadosDAO();
    }

    public boolean modificaDatos(CursadoModelo cursado) {
        return cursadoDAO.modificaDAO(cursado);
    }

    public boolean bajaDatos(JTable tabla) {

        return cursadoDAO.bajaDAO(tabla);
    }

}
