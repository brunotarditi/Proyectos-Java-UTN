/*Codifique un método denominado esPar que reciba como 
parámetro un valor numérico entero y retorne true en 
caso de que el numero sea par, caso contrario retorne false. 
Compruebe el funcionamiento del método solicitando 
al usuario del programa que ingrese números aleatorios. */
package Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        System.out.println("Ingrese un número entero");
        int numero = new Scanner(System.in).nextInt();
        System.out.println("¿El numero " + numero + " es Par?: " + esPar(numero));

    }

    public static boolean esPar(int numero) {

        return numero % 2 == 0;
    }
}
