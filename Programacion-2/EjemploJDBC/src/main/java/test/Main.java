package test;

import datos.Conexion;
import datos.IPersonaDAO;
import datos.PersonaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author Bruno Tarditi
 */
public class Main {

    public static void main(String[] args) {

        Connection conexion = null;
        try {

            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            IPersonaDAO iPersonaDAO = new PersonaDAO(conexion);
            List<Persona> personas = iPersonaDAO.select();
            personas.forEach((persona) -> {
                System.out.println(persona);
            });

            conexion.commit();
            System.out.println("Se ha hecho commit de la transacción");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
