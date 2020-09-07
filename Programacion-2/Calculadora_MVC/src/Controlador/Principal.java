package Controlador;

import Modelo.Modelo;
import Vista.Vista;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {
    public static void main(String[] args) {
        
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista,modelo);
        controlador.iniciar();
    }
}
