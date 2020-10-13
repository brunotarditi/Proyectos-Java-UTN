package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bruno Tarditi
 */
public class Conexion {
    
    private Connection conexion = null;
    private String name = "tp6_jsp";
    private String user = "root";
    private String password = "1234";
    private String host = "localhost";
    private String port = "3307";
    
    public Connection establecerConexion(){
        if (conexion != null) {
            return conexion;
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
            conexion = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return conexion;
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
