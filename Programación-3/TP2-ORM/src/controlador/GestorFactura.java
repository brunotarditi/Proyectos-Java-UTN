package controlador;

import persistencia.ConfigHibernate;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorFactura extends Gestor {

    public GestorFactura() {
        sesion = ConfigHibernate.openSession();
    }
}
