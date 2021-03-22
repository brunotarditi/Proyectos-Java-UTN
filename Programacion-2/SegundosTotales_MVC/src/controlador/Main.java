package controlador;

import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author Bruno Tarditi
 */
public class Main {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(modelo, vista);
    }
}
