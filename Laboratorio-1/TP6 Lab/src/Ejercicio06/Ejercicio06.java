/*
Codifique la clase celda con los atributos:
int fila;
int columna;
String valor;
 Crea una clase Matriz que contenga una variable global
ArrayList<Celda>
ArrayList<Celda> matrizCuadrada = new ArrayList<Celda>();
 Codifique un programa que solicite al usuario un valor para la
celda y que solicite la posición donde se desea almacenar el valor,
cree una instancia de la clase Celda, asigne los valores cargados
por el usuario y agregue la instancia a la lista matrizCuadrada;
repita este proceso hasta que el usuario ingrese como valor la
cadena “FIN”.
 Muestre por pantalla los valores cargados en matrizCuadrada.
 Codifique un método que reciba como parámetro los valores fila y
columna y retorne el valor almacenado, en caso de que la fila y la
columna no exista retorne
 */
package Ejercicio06;

import java.util.*;

/**
 *
 * @author Bruno
 */
public class Ejercicio06 {

    public static ArrayList<Celda> matrizCuadrada = new ArrayList<>();

    public static void main(String[] args) {

        int buscarFila;
        int buscarColumna;
        String valor = "";
        do {
            System.out.println("Ingrese un valor para almacenar: ");
            valor = new Scanner(System.in).nextLine();
            if (valor.equals("FIN")) {
                break;
            }
            Celda c = new Celda();
            c.setValor(valor);
            System.out.println("Ingrese un valor para la fila: ");
            int fila = new Scanner(System.in).nextInt();
            c.setFila(fila);
            System.out.println("Ingrese un valor para la columna: ");
            int columna = new Scanner(System.in).nextInt();
            c.setColumna(columna);
            matrizCuadrada.add(c);
            System.out.println("Los valores ingresados son: ");
            System.out.println("VALOR:" + c.getValor());
            System.out.println("FILA: " + c.getFila());
            System.out.println("COLUMNA:" + c.getColumna());
            
        } while (!valor.equals("FIN"));
        System.out.println("Ingrese fila y columna a buscar: ");
        buscarFila = new Scanner(System.in).nextInt();
        buscarColumna = new Scanner(System.in).nextInt();
        obtenerValor(matrizCuadrada, buscarFila, buscarColumna);

    }

    public static void obtenerValor(ArrayList<Celda> matriz, int fila, int columna) {

        boolean celdaLlena = false;
        for (Celda p : matrizCuadrada) {
            if (p.getFila() == fila && p.getColumna() == columna) {
                System.out.println("El valor buscado es: " + p.getValor());
                celdaLlena = true;
            }
        }

        if (celdaLlena == false) {
            System.out.println("La fila y la columna no han sido asignada");
        }
    }

}
