package entidadesDAO;

import entidades.TipoArticulo;

import javax.persistence.Query;
import java.util.List;

public class TipoArticuloDAO extends GenericDAO{

    public Object buscarPorId(TipoArticulo tipoArticulo){
        entityManager = getEntityManager();
        return entityManager.find(TipoArticulo.class, tipoArticulo.getIdTipoArticulo());
    }

    public List<TipoArticulo> listar() {
        String consulta = "SELECT ta FROM TipoArticulo ta";
        entityManager = getEntityManager();
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(TipoArticulo tipoArticulo) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(tipoArticulo);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void actualizar(TipoArticulo tipoArticulo) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(tipoArticulo);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void eliminar(TipoArticulo tipoArticulo) {

        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(tipoArticulo));
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
