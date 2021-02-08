package test;

import datos.EntidadesDAO;
import entidades.*;

public class PersistenceApp {
    public static void main(String[] args) {

        Articulo articulo = new Articulo();
        //Domicilio domicilio = new Domicilio();
        //Factura factura = new Factura();
        //FacturaDetalle facturaDetalle = new FacturaDetalle();
        //Proveedor proveedor = new Proveedor();
        //TipoArticulo tipoArticulo = new TipoArticulo();
        EntidadesDAO entidadesDAO = new EntidadesDAO();
        entidadesDAO.createEntity(articulo);
        //entidadesDAO.createEntity(domicilio);
        //entidadesDAO.createEntity(factura);
        //entidadesDAO.createEntity(facturaDetalle);
        //entidadesDAO.createEntity(proveedor);
        //entidadesDAO.createEntity(tipoArticulo);

    }
}
