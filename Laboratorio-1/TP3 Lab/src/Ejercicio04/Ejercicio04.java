/*
Escriba una aplicación que:
a) lea 20 números decimales ingresados por teclado por el usuario y los coloque en un arreglo unidimensional.
b) determine y muestre el mayor de los números en el arreglo
c) determine y muestre el menor de los números del arreglo calcule y muestre el rango 
(diferencia entre el mayor y el menor) de los elementos en el arreglo
 */
package Ejercicio04;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        double array[] = new double[20];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese un número para la posición: " + i);
            double numero = new Scanner(System.in).nextInt();
            array[i] = numero;
        }

        muestroArreglo(array);
        double mayor = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > mayor) {
                mayor = array[i];
            }

        }
        System.out.println("El mayor es: " + mayor);

        double menor = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
            }

        }
        System.out.println("El menor es: " + menor);
        double diferencia = mayor - menor;
        System.out.println("La diferencia entre el mayor y menor es: " + diferencia);
    }

    private static void muestroArreglo(double[] arreglos) {

        String cadena = ", ";

        for (int i = 0; i < arreglos.length; i++) {
            if (i > 0) {
                cadena += ", ";
            }
            cadena += arreglos[i];

        }

        System.out.println("valores: " + cadena);

    }

}
