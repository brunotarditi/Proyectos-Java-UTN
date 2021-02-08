package datos;

import entidades.*;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class EntidadesDAO {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EntidadesDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceApp");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createEntity(Object object) {

        try {
            entityManager.getTransaction().begin();
            object = new Object();
            entityManager.persist(object);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    public List<Object> listEntity (String s){
        Query query = entityManager.createQuery(s);
        List<Object> objects = query.getResultList();
        return objects;
    }

    public void createArticle(Articulo articulo) {

        try {
            entityManager.getTransaction().begin();
            articulo = new Articulo();
            entityManager.persist(articulo);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }
}
