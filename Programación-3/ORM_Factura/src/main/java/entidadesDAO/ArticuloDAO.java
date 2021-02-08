package entidadesDAO;

import entidades.Articulo;

import javax.persistence.Query;
import java.util.List;

public class ArticuloDAO extends GenericDAO{

    public Object buscarPorId(Articulo articulo){
        entityManager = getEntityManager();
        return entityManager.find(Articulo.class, articulo.getIdArticulo());
    }

    public List<Articulo> listar() {
        String consulta = "SELECT a FROM Articulo a";
        entityManager = getEntityManager();
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Articulo articulo) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(articulo);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void actualizar(Articulo articulo) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(articulo);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void eliminar(Articulo articulo) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(articulo));
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
