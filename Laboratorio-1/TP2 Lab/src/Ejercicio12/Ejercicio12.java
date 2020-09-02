/*
 12-Dada una cadena, extraer la cuarta y quinta letra usando el método substring.
 */
package Ejercicio12;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio12 {

   
    public static void main(String[] args) {
        
        System.out.println("Ingrese una frase o palabra mayor o igual a 5 caracteres");
        String cadena = new Scanner(System.in).nextLine();
        System.out.println("La cuarta letra utilizada es: " + cadena.substring(3, 4) + "\nla quinta letra utilizada es: " + cadena.substring(4, 5));
        

        
        /* Trocea un String desde una
        posición a otra. Devuelve un String*/ 
    }
    
}
