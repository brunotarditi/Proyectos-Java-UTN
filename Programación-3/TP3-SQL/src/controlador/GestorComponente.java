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
import modelo.ComponenteModelo;
import modelo.ComputadoraModelo;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorComponente {

    DataBase db = new DataBase();
    Connection conexion = db.establecerConexion();
    GestorComputadora _gestorComputadora = new GestorComputadora();

    //Trae una lista de componentes
    public List<ComponenteModelo> dameListaComponentes() {
        ResultSet rs = null;
        ComponenteModelo componente = new ComponenteModelo();
        GestorComputadora gc = new GestorComputadora();
        List<ComponenteModelo> componentes = new ArrayList<ComponenteModelo>();

        try {
            Statement s = conexion.createStatement();

            rs = s.executeQuery("select * from componente");
            while (rs.next()) {
                componente = new ComponenteModelo();
                componente.setId(rs.getLong("id"));
                componente.setNombre(rs.getString("nombre"));
                componente.setNroSerie(rs.getString("nroSerie"));
                componente.setComputadora(gc.dameComputadoraFila(rs.getLong("idComputadora")));              
                componentes.add(componente);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentes;
    }
    //Inserta los componentes

    public void insertarComponente(String nombre, String nroSerie, Long idComputadora) throws SQLException {
        conexion.setAutoCommit(false);
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement("INSERT INTO componente (nombre, nroSerie, idComputadora) VALUE (?, ?, ?)");

            ps.setString(1, nombre);
            ps.setString(2, nroSerie);
            ps.setLong(3, idComputadora);
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
    
    public List<String> traeIdComputadora(){
        
        List <String> id_computadora = new ArrayList<String>();
        ResultSet rs = null;
        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery("select id from computadora");
             id_computadora.add("");
            while (rs.next()) {
                             
                id_computadora.add(Long.toString(rs.getLong(1)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id_computadora;
        
    }
    
    public ComponenteModelo dameComponenteFila(Long id) {
        ResultSet rs = null;
        ComponenteModelo componente = new ComponenteModelo();
        GestorComputadora gc = new GestorComputadora();
        try {
            Statement s = conexion.createStatement();

            rs = s.executeQuery("select * from componente where id = " + id);
            if (rs.next()) {
                componente.setId(rs.getLong("id"));
                componente.setNombre(rs.getString("nombre"));
                componente.setNroSerie(rs.getString("nroSerie"));
                componente.setComputadora(gc.dameComputadoraFila(rs.getLong("idComputadora")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componente;
    }
    
    public void editarComponente(Long id, String nombre, String nroSerie, Long idComputadora) {
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE componente SET nombre = ?, nroSerie = ?, idComputadora = ? where id = ?");
            // Se establecen los parámetros y se ejecuta la sentencia.
            ps.setString(1, nombre);
            ps.setString(2, nroSerie);
            ps.setLong(3, idComputadora);
            ps.setLong(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarComponente(Long id) {
        try {
            Statement st = conexion.createStatement();
            String sql = "DELETE FROM componente WHERE id = " + id;
            int delete = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Cierra la conexion
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
