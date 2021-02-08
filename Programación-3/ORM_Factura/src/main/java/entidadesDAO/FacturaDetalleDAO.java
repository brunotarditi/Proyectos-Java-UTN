package entidadesDAO;

import entidades.FacturaDetalle;

import javax.persistence.Query;
import java.util.List;

public class FacturaDetalleDAO extends GenericDAO{

    public Object buscarPorId(FacturaDetalle facturaDetalle){
        entityManager = getEntityManager();
        return entityManager.find(FacturaDetalle.class, facturaDetalle.getIdFacturaDetalle());
    }

    public List<FacturaDetalle> listar() {
        String consulta = "SELECT fd FROM FacturaDetalle fd";
        entityManager = getEntityManager();
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(FacturaDetalle facturaDetalle) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(facturaDetalle);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void actualizar(FacturaDetalle facturaDetalle) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(facturaDetalle);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void eliminar(FacturaDetalle facturaDetalle) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(facturaDetalle));
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
