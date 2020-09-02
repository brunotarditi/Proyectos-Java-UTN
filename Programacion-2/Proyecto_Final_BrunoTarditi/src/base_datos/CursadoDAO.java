package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.CursadoModelo;

/**
 *
 * @author Bruno Tarditi
 */
public class CursadoDAO extends SQLQuery {

    private ArrayList<CursadoModelo> cursados;
    private CursadoModelo cursado;

    public ArrayList<CursadoModelo> getCursados() {
        return cursados;
    }

    public void setCursados(ArrayList<CursadoModelo> cursados) {
        this.cursados = cursados;
    }

    public boolean cargarDatosDAO(CursadoModelo cursado) {

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO cursado (cur_alu_dni, cur_mat_cod, cur_nota) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement(sql);
            preparedStmt.setLong(1, cursado.getCur_alu_dni());
            preparedStmt.setLong(2, cursado.getCur_mat_cod());
            preparedStmt.setInt(3, cursado.getCur_nota());
            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public ArrayList<CursadoModelo> mostrarCursadosDAO() {

        cursados = new ArrayList();

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from cursado");
            ResultSet hoja_de_resultado = consulta.executeQuery();
            while (hoja_de_resultado.next()) {
                cursado = new CursadoModelo();
                cursado.setCur_alu_dni(hoja_de_resultado.getLong(1));
                cursado.setCur_mat_cod(hoja_de_resultado.getLong(2));
                cursado.setCur_nota(hoja_de_resultado.getInt(3));
                cursados.add(cursado);

            }

            this.desconectar();

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return cursados;
    }

    public boolean modificaDAO(CursadoModelo cursado) {
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement("UPDATE cursado SET cur_mat_cod=?, cur_nota=? WHERE cur_alu_dni=?");
            preparedStmt.setLong(1, cursado.getCur_mat_cod());
            preparedStmt.setInt(2, cursado.getCur_nota());
            preparedStmt.setLong(3, cursado.getCur_alu_dni());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean bajaDAO(JTable tabla) {
        int seleccion;
        cursados = new ArrayList(mostrarCursadosDAO());
        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("DELETE FROM cursado WHERE cur_alu_dni = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, cursados.get(seleccion).getCur_alu_dni());
            consulta.executeUpdate();

            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    

    public ArrayList<String> claveAluDniDAO() {
        ArrayList<String> cur_alu_dni = new ArrayList<>();
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select alu_dni from alumno");
            ResultSet resultados = consulta.executeQuery();
            cur_alu_dni.add("");
            while (resultados.next()) {
                cur_alu_dni.add(Long.toString(resultados.getLong(1)));
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cur_alu_dni;
    }

    public ArrayList<String> claveMatCodDAO() {
        ArrayList<String> cur_mat_cod = new ArrayList<>();
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareCall("select mat_cod from materia");
            ResultSet resultados = consulta.executeQuery();
            cur_mat_cod.add("");
            while (resultados.next()) {
                cur_mat_cod.add(Long.toString(resultados.getLong(1)));
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cur_mat_cod;

    }

}
