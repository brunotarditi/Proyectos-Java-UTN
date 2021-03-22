package datos;

import modelo.Detalles;
import modelo.Existencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExistenciaDao {

    private static final String SQL_SELECT = "SELECT * FROM existencias WHERE id_producto=?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM existencias WHERE id_existencia=?";
    private static final String SQL_INSERT = "INSERT INTO existencias (cantidad, precio_costo, id_producto) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE existencias SET cantidad=?, precio_costo=?, id_producto=? WHERE id_existencia=?";
    private static final String SQL_DELETE = "DELETE FROM existencias WHERE id_existencia=?";

    public List<Existencia> getAllStocks(Existencia existencia) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Existencia> existencias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, existencia.getIdProducto());
            rs = ps.executeQuery();
            while (rs.next()) {
                int idExistencia = rs.getInt("id_existencia");
                int cantidad = rs.getInt("cantidad");
                double precioCosto = rs.getDouble("precio_costo");
                int idProducto = rs.getInt("id_producto");
                existencia = new Existencia(idExistencia, cantidad, precioCosto, idProducto);
                existencias.add(existencia);
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

        return existencias;
    }

    public Existencia getStock(Existencia existencia) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, existencia.getIdExistencia());
            rs = ps.executeQuery();
            while (rs.next()) {
                existencia.setCantidad(rs.getInt("cantidad"));
                existencia.setPrecioCosto(rs.getDouble("precio_costo"));
                existencia.setIdProducto(rs.getInt("id_producto"));

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

        return existencia;
    }

    public int insert(Existencia existencia) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, existencia.getCantidad());
            ps.setDouble(2, existencia.getPrecioCosto());
            ps.setInt(3, existencia.getIdProducto());

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

    public int update(Existencia existencia) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, existencia.getCantidad());
            ps.setDouble(2, existencia.getPrecioCosto());
            ps.setInt(3, existencia.getIdProducto());
            ps.setInt(4, existencia.getIdExistencia());
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

    public int delete(Existencia existencia) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, existencia.getIdExistencia());
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
