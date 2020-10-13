package controlador;

import conexionBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Persona;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorPersona {

    Conexion conn = new Conexion();
    Connection conexion = conn.establecerConexion();

    public List<Persona> dameListaPersonas() {
        ResultSet rs = null;
        Persona persona = new Persona();
        List<Persona> personas = new ArrayList<Persona>();

        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery("SELECT * FROM persona");
            while (rs.next()) {
                persona = new Persona();
                persona.setDni(rs.getLong("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDomicilio(rs.getString("domicilio"));
                personas.add(persona);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return personas;
    }

    public void insertarPersona(long dni, String nombre, String domicilio) throws SQLException {

        PreparedStatement ps = null;
        conexion.setAutoCommit(false);
        try {
            ps = conexion.prepareStatement("INSERT INTO persona (dni, nombre, domicilio) VALUE (?, ?, ?)");
            ps.setLong(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, domicilio);
            ps.executeUpdate();
            conexion.commit();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            conexion.rollback();
        } finally {
            conexion.setAutoCommit(true);
            if (ps != null) {
                ps.close();
            }
        }

    }

}
