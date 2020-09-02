/*
 10-Convertir una frase a mayúsculas o minúsculas, que daremos opción a que 
el usuario lo pida y mostraremos el resultado por pantalla.
 */
package Ejercicio10;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio10 {

    public static void main(String[] args) {

        System.out.println("Ingrese una frase: ");
        String frase = new Scanner(System.in).nextLine();
        String opcion = "opcion";
        while (!opcion.equals("a") && !opcion.equals("b")) {
            System.out.println("Escriba 'a' para mayúscula o 'b' para minúscula");
            opcion = new Scanner(System.in).nextLine();
        }

        if (opcion.equals("a")) {
            frase = frase.toUpperCase();
            System.out.println(frase);
        }

        if (opcion.equals("b")) {
            frase = frase.toLowerCase();
            System.out.println(frase);
        }

    }

}
