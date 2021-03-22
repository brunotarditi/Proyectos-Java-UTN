package datos;

import modelo.Detalles;
import modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetallesDao {

    private static final String SQL_SELECT = "SELECT * FROM detalles WHERE id_producto=?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM detalles WHERE id_detalles=?";
    private static final String SQL_INSERT = "INSERT INTO detalles (saldo_cantidad, entrada_cantidad, salida_cantidad, saldo_costo, entrada_costo, salida_costo ,detalle, id_producto, existencias) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE detalles SET saldo_cantidad=?, entrada_cantidad=?, salida_cantidad=?, saldo_costo=?, entrada_costo=?, salida_costo=?, detalle=?, id_producto=?, existencias=? WHERE id_detalles=?";
    private static final String SQL_DELETE = "DELETE FROM detalles WHERE id_detalles=?";

    public List<Detalles> getAllDetails(Detalles detalle) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Detalles> detalles = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, detalle.getIdProducto());
            rs = ps.executeQuery();
            while (rs.next()) {
                int idDetalles = rs.getInt("id_detalles");
                int saldoCantidad = rs.getInt("saldo_cantidad");
                int entradaCantidad = rs.getInt("entrada_cantidad");
                int salidaCantidad = rs.getInt("salida_cantidad");
                double saldoCosto = rs.getDouble("saldo_costo");
                double entradaCosto = rs.getDouble("entrada_costo");
                double salidaCosto = rs.getDouble("salida_costo");
                String detail = rs.getString("detalle");
                int idProducto = rs.getInt("id_producto");
                String existencias = rs.getString("existencias");
                detalle = new Detalles(idDetalles, saldoCantidad, entradaCantidad, salidaCantidad, saldoCosto, entradaCosto, salidaCosto, detail, idProducto, existencias);
                detalles.add(detalle);
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

        return detalles;
    }

    public Detalles getDetail(Detalles detalle) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            Statement s = conn.createStatement();
            ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, detalle.getIdDetalles());
            rs = ps.executeQuery();
            while (rs.next()) {
                detalle.setSaldoCantidad(rs.getInt("saldo_cantidad"));
                detalle.setEntradaCantidad(rs.getInt("entrada_cantidad"));
                detalle.setSalidaCantidad(rs.getInt("salida_cantidad"));
                detalle.setSaldoCosto(rs.getDouble("saldo_costo"));
                detalle.setEntradaCosto(rs.getDouble("entrada_costo"));
                detalle.setSalidaCosto(rs.getDouble("salida_costo"));
                detalle.setDetalle(rs.getString("detalle"));
                detalle.setIdProducto(rs.getInt("id_producto"));
                detalle.setExistencias(rs.getString("existencias"));
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

        return detalle;
    }

    public int insert(Detalles detalle) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, detalle.getSaldoCantidad());
            ps.setInt(2, detalle.getEntradaCantidad());
            ps.setInt(3, detalle.getSalidaCantidad());
            ps.setDouble(4, detalle.getSaldoCosto());
            ps.setDouble(5, detalle.getEntradaCosto());
            ps.setDouble(6, detalle.getSalidaCosto());
            ps.setString(7, detalle.getDetalle());
            ps.setInt(8, detalle.getIdProducto());
            ps.setString(9, detalle.getExistencias());
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

    public int update(Detalles detalles) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, detalles.getSaldoCantidad());
            ps.setInt(2, detalles.getEntradaCantidad());
            ps.setInt(3, detalles.getSalidaCantidad());
            ps.setDouble(4, detalles.getSaldoCosto());
            ps.setDouble(5, detalles.getEntradaCosto());
            ps.setDouble(6, detalles.getSalidaCosto());
            ps.setString(7, detalles.getDetalle());
            ps.setInt(8, detalles.getIdProducto());
            ps.setString(9, detalles.getExistencias());
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

    public int delete(Detalles detalles) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, detalles.getIdDetalles());
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
