package controlador;

import conexion.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Computadora;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorComputadora {

    DataBase db = new DataBase();
    Connection conexion = db.establecerConexion();

    //Trae una lista de computadoras
    public List<Computadora> dameListaComputadoras() {
        ResultSet rs = null;
        Computadora computadora = new Computadora();
        List<Computadora> computadoras = new ArrayList<Computadora>();

        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery("select * from computadora");
            while (rs.next()) {
                computadora = new Computadora();
                computadora.setId(rs.getLong("id"));
                computadora.setCodigo(rs.getString("codigo"));
                computadora.setMarca(rs.getString("marca"));
                computadora.setModelo(rs.getString("modelo"));
                computadoras.add(computadora);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computadoras;
    }

    public void insertarComputadora(String codigo, String marca, String modelo) throws SQLException {

        PreparedStatement ps = null;
        conexion.setAutoCommit(false);
        try {
            ps = conexion.prepareStatement("INSERT INTO computadora (codigo, marca, modelo) VALUE (?, ?, ?)");
            ps.setString(1, codigo);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.executeUpdate();
            conexion.commit();

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            conexion.rollback();
        } finally {
            conexion.setAutoCommit(true);
            if (ps != null) {
                ps.close();
            }
        }

    }

    public Computadora dameComputadoraFila(Long idComputadora) {
        ResultSet rs = null;
        Computadora computadora = new Computadora();
        try {
            Statement s = conexion.createStatement();

            rs = s.executeQuery("select * from computadora where id = " + idComputadora);
            if (rs.next()) {
                computadora.setId(rs.getInt("id"));
                computadora.setCodigo(rs.getString("codigo"));
                computadora.setMarca(rs.getString("nombre"));
                computadora.setModelo(rs.getString("modelo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computadora;
    }


    //CERRAR CONEXION
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
