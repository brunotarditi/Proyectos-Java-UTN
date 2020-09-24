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
import modelo.Componente;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorComponente {

    DataBase db = new DataBase();
    Connection conexion = db.establecerConexion();
    GestorComputadora _gestorComputadora = new GestorComputadora();

    //Trae una lista de componentes
    public List<Componente> dameListaComponentes() {
        ResultSet rs = null;
        Componente componente = new Componente();
        GestorComputadora gc = new GestorComputadora();
        List<Componente> componentes = new ArrayList<Componente>();
        

        try {
            Statement s = conexion.createStatement();

            rs = s.executeQuery("select * from componente");
            while (rs.next()) {
                componente = new Componente();
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

    public void insertarComponente(String nombre, String nroSerie, String marca, String modelo, String codigo) throws SQLException {
        conexion.setAutoCommit(false);
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement("INSERT INTO (id, nombre, nroSerie, idComputadora) VALUE (?, ?)");

            ps.setString(1, nombre);
            ps.setString(2, nroSerie);
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

    //Cierra la conexion
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
