package entidadesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO {

    protected static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    private static final String PU = "PersistencePU";

    public GenericDAO() {
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PU);
        }
    }

    protected  EntityManager getEntityManager(){
        if (entityManager == null){
            entityManager = entityManagerFactory.createEntityManager();
        }
        return  entityManager;
    }
}
