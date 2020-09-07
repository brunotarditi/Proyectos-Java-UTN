/*
 /**
 * Crea una clase Matriz que contenga una variable global ArrayList<Celda>
 * ArrayList<Celda> matrizCuadrada = new ArrayList<Celda>();
 */
package Ejercicio06;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Matriz {
    
    ArrayList<Celda> matrizCuadrada = new ArrayList<Celda>();    

    public void setMatrizCuadrada(ArrayList<Celda> matrizCuadrada) {
        this.matrizCuadrada = matrizCuadrada;
    }

    public ArrayList<Celda> getMatrizCuadrada() {
        return matrizCuadrada;
    }
}
