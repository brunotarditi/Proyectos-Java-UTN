/*
 5-Solicite el ingreso de un número y conviértalo a un String mediante String.valueOf
 */
package Ejercicio05;
/**
 *
 * @author Bruno
 */
import java.util.Scanner;


public class Ejercicio05 {

   
    public static void main(String[] args) {
        
        
        System.out.println("Ingrese un número: ");
        int numero = new Scanner (System.in).nextInt();
        String cadena = String.valueOf(numero);
        
        System.out.println("Su número en cadena es: " + cadena);
        
      /**String.valueOf() se usa para obtener la representación String de un valor u objeto. 
        (Podríamos decir que convierte un valor u objeto en su representación de tipo String).
        Por ejemplo, si tienes un valor 100 almacenado en una variable de tipo int, puedes obtener 
        la representación del número 100 como una cadena de letras.*/
    }
    
}
