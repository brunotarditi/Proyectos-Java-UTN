package controlador;

import conexion.ConfigHibernate;
import conexion.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.Computadora;
import org.hibernate.Query;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorComputadora extends Gestor {

    DataBase db = new DataBase();
    Connection conexion = db.establecerConexion();

    public GestorComputadora() {
        sesion = ConfigHibernate.openSession();
    }

    //Trae una lista de computadoras
    public List<Computadora> dameListaComputadorasHQL() {

        sesion = ConfigHibernate.openSession();
        try {

            Query consulta = sesion.createQuery("FROM Computadora");
            List<Computadora> lista;
            lista = consulta.list();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }

    //INSERTAR COMPUTADORA
    public void insertarComputadoraHQL(String codigo, String marca, String modelo) throws SQLException {

        try {
            Computadora computadora = new Computadora();
            computadora.setCodigo(codigo);
            computadora.setMarca(marca);
            computadora.setModelo(modelo);

            this.guardar(computadora);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //DAME COMPUTADORA 
    public Computadora dameComputadoraFilaHQL(Long id) {
        sesion = ConfigHibernate.openSession();
        try {
            Query consulta = sesion.createQuery("FROM Computadora WHERE id = :idParam");
            consulta.setParameter("idParam", id);
            Computadora computadora = (Computadora) consulta.uniqueResult();
            return computadora;
        } catch (Exception e) {
            e.printStackTrace();
           
        }
         return null;
    }

    //EDITAR COMPUTADORA
    public void editarComputadoraHQL(Long id, String codigo, String marca, String modelo) {
        try {
            Computadora computadora = this.dameComputadoraFilaHQL(id);
            computadora.setCodigo(codigo);
            computadora.setMarca(marca);
            computadora.setModelo(modelo);
            this.guardar(computadora);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //ELIMINAR COMPUTADORA
    public void eliminarComputadoraHQL(Long id) {
        try {
            Computadora computadora = this.dameComputadoraFilaHQL(id);
            this.eliminar(computadora);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //CERRAR CONEXION
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
