package controlador;

import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author Bruno Tarditi
 */
public class main {

    public static void main(String[] args) {

        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista,modelo);
    }
}
