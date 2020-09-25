package controlador;

import conexion.ConfigHibernate;
import conexion.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Componente;
import modelo.Computadora;
import org.hibernate.Query;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorComponente extends Gestor{

    DataBase db = new DataBase();
    Connection conexion = db.establecerConexion();
    GestorComputadora _gestorComputadora = new GestorComputadora();
    
    public GestorComponente() {
        sesion = ConfigHibernate.openSession();
    }

    //Trae una lista de componentes
    public List<Componente> dameListaComponentesHQL() {
        sesion = ConfigHibernate.openSession();
        try {

            Query consulta = sesion.createQuery("FROM Componente");
            List<Componente> lista;
            lista = consulta.list();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    //Inserta los componentes

    public void insertarComponenteHQL(String nombre, String nroSerie, Long idComputadora) throws SQLException {
         try {
            GestorComputadora gc = new GestorComputadora();
            Componente componente = new Componente();
            componente.setNombre(nombre);
            componente.setNroSerie(nroSerie);
            componente.setComputadora(gc.dameComputadoraFilaHQL(idComputadora));
            this.guardar(componente);

        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        
        public List<String> traeIdComputadoraHQL() {
        List<String> idComputadoras = new ArrayList<>();
            sesion = ConfigHibernate.openSession();
         try {
            Query consulta = sesion.createQuery("FROM Computadora");
            List<Computadora> lista;
            lista = consulta.list();
            for (Computadora computadora : lista) {
                idComputadoras.add(String.valueOf(computadora.getId()));
            }   
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return idComputadoras;
     
    }
        
    
    
    public Componente dameComponenteFilaHQL(Long id) {
        sesion = ConfigHibernate.openSession();
        try {
            Query consulta = sesion.createQuery("FROM Componente WHERE id = :idParam");
            consulta.setParameter("idParam", id);
            Componente componente = (Componente) consulta.uniqueResult();
            return componente;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
        
    }
    
    public void editarComponenteHQL(Long id, String nombre, String nroSerie, Long idComputadora) {
        try {
            GestorComputadora gc = new GestorComputadora();
            Componente componente = this.dameComponenteFilaHQL(id);
            componente.setNombre(nombre);
            componente.setNroSerie(nroSerie);
            componente.setComputadora(gc.dameComputadoraFilaHQL(idComputadora));
            this.guardar(componente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarComponenteHQL(Long id) {
        try {
            Componente componente = this.dameComponenteFilaHQL(id);
            this.eliminar(componente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Cierra la conexion
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
