/*
7-Solicite el ingreso de una cadena y determine el tamaño de la misma 
y cuantas vocales tiene en total (recorre el String con charAt)
 */
package Ejercicio07;

/**
 *
 * @author Bruno
 */
import java.util.Scanner;

public class Ejercicio07 {

    public static void main(String[] args) {
        System.out.println("Ingrese una cadena: ");
        String cadena = new Scanner(System.in).nextLine();
        int contador = 0;

        for (int vocales = 0; vocales < cadena.length(); vocales++) {

            if ((cadena.charAt(vocales) == 'a') || (cadena.charAt(vocales) == 'e') || (cadena.charAt(vocales) == 'i') 
                    || (cadena.charAt(vocales) == 'o') || (cadena.charAt(vocales) == 'u')) {

                contador++;
            }

        }

        System.out.println("El tamaño de la misma es: " + cadena.length());
        System.out.println("El total de vocales es: " + contador);

    }

}
