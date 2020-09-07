/*
Cree un programa que permita ingresar por teclado un valor entero, mediante el valor
entero cree una matriz de 2 dimensiones de orden igual al valor entero.
Cargue cada una de las posiciones del array con valor cero a excepción de los elementos
que componen la matriz identidad, los cuales deberán tener el valor 1 asignado.
 */
package Ejercicio03;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        System.out.println("Ingrese un número entero para una matriz cuadrada:");
        int entero = new Scanner(System.in).nextInt();
        int matriz[][] = new int[entero][entero];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }

            }

        }

        System.out.println("La matriz identidad es de tamaño: " + entero + " x " + entero);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println("");
        }

    }

}
