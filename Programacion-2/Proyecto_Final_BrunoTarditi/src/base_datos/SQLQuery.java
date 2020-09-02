package base_datos;

import java.sql.*;

/**
 *
 * @author Bruno Tarditi
 */
public class SQLQuery {

    protected Connection connect;
    protected PreparedStatement consulta;
    protected ResultSet datos;

    public void conectar(String server, String base, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connect = DriverManager.getConnection("jdbc:mysql://" + server + "/" + base + "?useUnicode=true&serverTimezone=GMT-3", user, password);
    }

    public void desconectar() throws SQLException {
        this.connect.close();
        this.consulta.close();
    }

    public void desconectar(ResultSet re_Set) throws SQLException {

        this.desconectar();
        re_Set.close();

    }

}
