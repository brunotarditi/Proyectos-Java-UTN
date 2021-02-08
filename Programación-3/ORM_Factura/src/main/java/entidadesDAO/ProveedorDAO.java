package entidadesDAO;

import entidades.Proveedor;

import javax.persistence.Query;
import java.util.List;

public class ProveedorDAO extends GenericDAO{

    public Object buscarPorId(Proveedor proveedor){
        entityManager = getEntityManager();
        return entityManager.find(Proveedor.class, proveedor.getIdProveedor());
    }

    public List<Proveedor> listar() {
        String consulta = "SELECT p FROM Proveedor p";
        entityManager = getEntityManager();
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Proveedor proveedor) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(proveedor);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void actualizar(Proveedor proveedor) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(proveedor);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void eliminar(Proveedor proveedor) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(proveedor));
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
