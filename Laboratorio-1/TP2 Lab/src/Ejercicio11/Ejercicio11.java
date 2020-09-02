/*
 11-Pedir dos palabras por teclado, indicar si son iguales. (equals, compareTo, compareToIgnoreCase)
 */
package Ejercicio11;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio11 {

    public static void main(String[] args) {

        System.out.println("Escriba dos palabras");
        String palabra1 = new Scanner(System.in).nextLine();
        System.out.println("Palabra ingresada: " + palabra1);
        String palabra2 = new Scanner(System.in).nextLine();
        System.out.println("Palabra ingresada: " + palabra2);
        if (palabra1.equals(palabra2)) {

            System.out.println("\nLas palabras son iguales\n");
        } else {
            System.out.println("\nLas palabras son distintas\n");
        }
        
        /*Aclaración de compareTo y compareToIgnoreCase: 
        Sirve para comparar cadenas,
        devuelve un número según el
        resultado. Recuerda que no
        sigue el alfabeto español, lo
        compara según la tabla ASCII.*/ 
        System.out.println("Según el código ASCII: ");
        int comparar = palabra1.compareTo(palabra2);
        if (comparar == 0) {
            System.out.println("Las dos palabras ingresadas son iguales");
        }
        if (comparar > 0) {
            System.out.println("La primer palabra es más grande que la segunda");
        }
        if (comparar < 0) {
            System.out.println("La segunda palabra es más grande que la primera");
        }

        comparar = palabra1.compareToIgnoreCase(palabra2);

        if (comparar == 0) {
            System.out.println("\nLas dos palabras ingresadas son iguales, ignorando mayúsculas y minúsculas");
        }
        if (comparar > 0) {
            System.out.println("\nLa primer palabra es más grande que la segunda, ignorando mayúsculas y minúsculas");
        }
        if (comparar < 0) {
            System.out.println("\nLa segunda palabra es más grande que la primera, ignorando mayúsculas y minúsculas");
        }
    }

}
