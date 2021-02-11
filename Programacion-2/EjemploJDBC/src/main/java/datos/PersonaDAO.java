package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author Bruno Tarditi
 */
public class PersonaDAO implements IPersonaDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id=?";

    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<Persona> select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new Persona(id, nombre, apellido, email, telefono);
                personas.add(persona);
            }
            /*} catch (SQLException ex) {
            ex.printStackTrace(System.out);*/
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }

    @Override
    public int insert(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            registros = ps.executeUpdate();
            /*} catch (SQLException ex) {
            ex.printStackTrace(System.out);*/
        } finally {
            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int update(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setLong(5, persona.getId());
            registros = ps.executeUpdate();
            /*} catch (SQLException ex) {
            ex.printStackTrace(System.out);*/
        } finally {
            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int delete(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setLong(1, persona.getId());
            registros = ps.executeUpdate();
            /*} catch (SQLException ex) {
            ex.printStackTrace(System.out);*/
        } finally {
            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }
}
