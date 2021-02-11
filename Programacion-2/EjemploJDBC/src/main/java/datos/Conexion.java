package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Bruno Tarditi
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/persistence_db?useSSL=false&Timezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";
    
    public static DataSource geDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(JDBC_URL);
        basicDataSource.setUsername(JDBC_USER);
        basicDataSource.setPassword(JDBC_PASSWORD);
        //Definimos el tamanio inicial del pool de conexiones
        basicDataSource.setInitialSize(50);
        return basicDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return geDataSource().getConnection();
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

}
