/*
8-Reemplaza todas las a del String anterior por una e. (aplique replace)
 */
package Ejercicio08;
/**
 *
 * @author Bruno
 */
import java.util.Scanner;


public class Ejercicio08 {


    public static void main(String[] args) {
       
        System.out.println("Ingrese una cadena: ");
        String cadena = new Scanner(System.in).nextLine();
        System.out.println(cadena.replace('a', 'e'));
        
       
    }
    
}
