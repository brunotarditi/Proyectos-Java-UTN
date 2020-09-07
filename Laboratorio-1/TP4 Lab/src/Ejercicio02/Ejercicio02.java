/*
Crea un programa que pida por pantalla 2 valores numÃ©ricos enteros X e Y. Cree un
primer array de tamaÃ±o [X,Y] de tipo entero y almacene en cada posición un valor
entero que deberÃ¡ ser ingresado por el usuario. A continuación cree un segundo
array de tamaÃ±o [Y,X] y almacene en cada posiciÃ³n un valor entero que deberÃ¡ ser
ingresado por el usuario. Finalmente cree un tercer array de tamaño [X,Y] que serÃ¡
el resultante de mutiplicar cada una de las posiciones de las filas del array uno por
cada una de las posiciones de las columnas del array 2.
Muestre por pantalla cada uno de los arrays con sus valores.
 */
package Ejercicio02;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        System.out.println("Ingrese dos valores para el tamaño de la matriz: ");
        int valor1 = new Scanner(System.in).nextInt();
        System.out.println("Segundo valor: ");
        int valor2 = new Scanner(System.in).nextInt();

        System.out.println("-----------------------------------------------");
        int arreglo1[][] = new int[valor1][valor2];
        System.out.println("El tamaño de la matriz 1 es de: " + valor1 + " * " + valor2);
        System.out.println("-----------------------------------------------");
        int arreglo2[][] = new int[valor2][valor1];
        System.out.println("El tamño de la matriz 2 es de : " + valor2 + " * " + valor1);
        System.out.println("-----------------------------------------------");
            
        System.out.println("Ingrese los valores para la matriz 1: ");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < valor1; i++) {
            for (int j = 0; j < valor2; j++) {
                System.out.println("Ingrese un número para la posición " + i + " * " + j);
                int valores = new Scanner(System.in).nextInt();
                arreglo1[i][j] = valores;
            }
        }
        System.out.println("");
        System.out.println("Ingrese los valores para la matriz 2: ");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < valor2; i++) {
            for (int j = 0; j < valor1; j++) {
                System.out.println("Ingrese un número para la posición " + i + " * " + j);
                int valores = new Scanner(System.in).nextInt();
                arreglo2[i][j] = valores;
            }
        }
        int arreglo3[][] = new int[valor1][valor2];
        System.out.println("\nMATRIZ RESULTANTE");
        for (int i = 0; i < valor1; i++) {
            for (int j = 0; j < valor2; j++) {
                arreglo3[i][j] = arreglo1[i][j] * arreglo2[j][i];
                System.out.print(arreglo3[i][j] + " ");
            }

            System.out.println("");
        }

    }

}
