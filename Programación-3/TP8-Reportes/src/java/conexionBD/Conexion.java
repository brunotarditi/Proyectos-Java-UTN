package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bruno Tarditi
 */
public class Conexion {
    
    private Connection conexion = null;
    private String name = "world";
    private String user = "root";
    private String password = "1234";
    private String host = "localhost";
    private String port = "3306";
    private String base = "?useUnicode=true&serverTimezone=GMT-3";
    
    public Connection establecerConexion(){
        if (conexion != null) {
            return conexion;
        }
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + name + base;
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
