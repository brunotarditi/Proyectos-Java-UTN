package entidadesDAO;

import entidades.Domicilio;

import javax.persistence.Query;
import java.util.List;

public class DomicilioDAO extends GenericDAO {

    public Object buscarPorId(Domicilio domicilio){
        entityManager = getEntityManager();
        return entityManager.find(Domicilio.class, domicilio.getIdDomicilio());
    }

    public List<Domicilio> listar() {
        String consulta = "SELECT d FROM Domicilio d";
        entityManager = getEntityManager();
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Domicilio domicilio) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(domicilio);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void actualizar(Domicilio domicilio) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(domicilio);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void eliminar(Domicilio domicilio) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(domicilio));
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
