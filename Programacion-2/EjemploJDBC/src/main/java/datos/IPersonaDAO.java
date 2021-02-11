package datos;

import java.sql.SQLException;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author Bruno Tarditi
 */
public interface IPersonaDAO {
    
    public List<Persona> select() throws SQLException; 
    public int insert(Persona persona) throws SQLException;
    public int update(Persona persona) throws SQLException;
    public int delete(Persona persona) throws SQLException;
}
