package controlador;

import persistencia.ConfigHibernate;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorProveedores extends Gestor {

    public GestorProveedores() {
        sesion = ConfigHibernate.openSession();
    }
}
