package main;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Articulo articulo = new Articulo();
            Domicilio domicilio = new Domicilio();
            FacturaDetalle facturaDetalle = new FacturaDetalle();
            Factura factura = new Factura();
            Proveedor proveedor = new Proveedor();
            TipoArticulo tipoArticulo = new TipoArticulo();
            entityManager.persist(articulo);
            entityManager.persist(domicilio);
            entityManager.persist(facturaDetalle);
            entityManager.persist(factura);
            entityManager.persist(proveedor);
            entityManager.persist(tipoArticulo);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }



}