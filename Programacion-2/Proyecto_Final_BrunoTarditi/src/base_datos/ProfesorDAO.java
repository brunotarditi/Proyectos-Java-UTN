package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.ProfesorModelo;

/**
 *
 * @author Bruno Tarditi
 */
public class ProfesorDAO extends SQLQuery {

    private ArrayList<ProfesorModelo> profesores;
    private ProfesorModelo profesor;

    public ArrayList<ProfesorModelo> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<ProfesorModelo> profesores) {
        this.profesores = profesores;
    }

    public boolean cargarDatosDAO(ProfesorModelo profesor) {

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO profesor (prof_dni, prof_nombre, prof_apellido, prof_fec_nac, prof_domicilio, prof_telefono) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement(sql);
            preparedStmt.setLong(1, profesor.getDniProfe());
            preparedStmt.setString(2, profesor.getNombre());
            preparedStmt.setString(3, profesor.getApellido());
            preparedStmt.setDate(4, profesor.getFecha());
            preparedStmt.setString(5, profesor.getDomicilio());
            preparedStmt.setString(6, profesor.getTelefono());

            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public ArrayList<ProfesorModelo> mostrarProfesoresDAO() {

        profesores = new ArrayList();

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from profesor");
            ResultSet hoja_de_resultado = consulta.executeQuery();
            while (hoja_de_resultado.next()) {
                profesor = new ProfesorModelo();
                profesor.setDniProfe(hoja_de_resultado.getLong(1));
                profesor.setNombre(hoja_de_resultado.getString(2));
                profesor.setApellido(hoja_de_resultado.getString(3));
                profesor.setFecha(hoja_de_resultado.getDate(4));
                profesor.setDomicilio(hoja_de_resultado.getString(5));
                profesor.setTelefono(hoja_de_resultado.getString(6));
                profesores.add(profesor);

            }

            this.desconectar();

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return profesores;
    }

    public boolean modificaDAO(ProfesorModelo profesor) {
        try {
            this.conectar("localhost", "SGA_2020", "root", "1234");
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement("UPDATE profesor SET prof_nombre=?, prof_apellido=?, prof_fec_nac=?, prof_domicilio=?, prof_telefono=? WHERE prof_dni=?");
            preparedStmt.setString(1, profesor.getNombre());
            preparedStmt.setString(2, profesor.getApellido());
            preparedStmt.setDate(3, profesor.getFecha());
            preparedStmt.setString(4, profesor.getDomicilio());
            preparedStmt.setString(5, profesor.getTelefono());
            preparedStmt.setLong(6, profesor.getDniProfe());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean bajaDAO(JTable tabla) {
        int seleccion;
        profesores = new ArrayList(mostrarProfesoresDAO());
        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("DELETE FROM profesor WHERE prof_dni = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, profesores.get(seleccion).getDniProfe());
            consulta.executeUpdate();

            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean dniRepetidoDAO(ProfesorModelo profesor) {

        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from profesor where prof_dni=?");
            this.consulta.setLong(1, profesor.getDniProfe());
            ResultSet hojadeResultados = consulta.executeQuery();
            if (hojadeResultados.next()) {
                return false;
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
