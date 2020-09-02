package controlador;

import vista.MenuVista;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        MenuVista menu_vis = new MenuVista();
        MenuControlador menu_con = new MenuControlador(menu_vis);
        
        
    }
}
