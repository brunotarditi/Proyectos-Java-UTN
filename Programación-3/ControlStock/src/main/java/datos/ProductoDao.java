package datos;

import modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
    private static final String SQL_SELECT = "SELECT * FROM producto";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM producto WHERE id_producto=?";
    private static final String SQL_INSERT = "INSERT INTO producto (nombre) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre=? WHERE id_producto=?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_producto=?";

    public List<Producto> getAllProducts() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                producto = new Producto(idProducto, nombre);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return productos;
    }

    public Producto getProduct(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, producto.getIdProducto());
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setNombre(rs.getString("nombre"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return producto;
    }

    public int insert(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, producto.getNombre());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int update(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, producto.getNombre());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int delete(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, producto.getIdProducto());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

}
