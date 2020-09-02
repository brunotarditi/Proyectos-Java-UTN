/*
 13-Pedir el ingreso de dos cadenas por por teclado, indicar si la segunda 
cadena se encuentra dentro de la primera (usar indexOf o contains).
 */
package Ejercicio13;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio13 {


    public static void main(String[] args) {

        System.out.println("Ingrese dos frases");
        String cadena1 = new Scanner(System.in).nextLine();
        System.out.println("Ingrese la segunda");
        String cadena2 = new Scanner(System.in).nextLine();
        
        
        boolean a = cadena1.contains(cadena2);
        if (a == true) {
            System.out.println("La segunda frase se encuentra dentro de la primera");
        }
        else{
            System.out.println("La segunda frase no se encuentra dentro de la primera frase");
        }
        
    }
    
}
