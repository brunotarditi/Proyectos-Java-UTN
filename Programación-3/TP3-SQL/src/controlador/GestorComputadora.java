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
            Statement s = conexion.createStatement();

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
    
    
    //INSERTAR COMPUTADORA
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

    //DAME COMPUTADORA
    public Computadora dameComputadoraFila(Long idComputadora) {
        ResultSet rs = null;
        Computadora computadora = new Computadora();
        try {
            Statement s = conexion.createStatement();

            rs = s.executeQuery("select * from computadora where id = " + idComputadora);
            if (rs.next()) {
                computadora.setId(rs.getLong("id"));
                computadora.setCodigo(rs.getString("codigo"));
                computadora.setMarca(rs.getString("marca"));
                computadora.setModelo(rs.getString("modelo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computadora;
    }
    //EDITAR COMPUTADORA
    public void editarComputadora(Long id, String codigo, String marca, String modelo) {
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE computadora SET codigo = ?, marca = ?, modelo = ? where id = ?");
            // Se establecen los parámetros y se ejecuta la sentencia.
            ps.setString(1, codigo);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setLong(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ELIMINAR COMPUTADORA
    public void eliminarComputadora(Long id) {
        try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM computadora WHERE id = " + id;
            int delete = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
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
