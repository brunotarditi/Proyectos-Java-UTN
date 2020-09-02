/*
 1-CASTEO: Codifique un programa que solicite el ingreso de un numero decimal y asigne 
el mismo a una variable valorDecimal de tipo double, aplique las operaciones de CASTING 
para convertir la variable a los siguientes tipos de datos, short, int, long, 
String, float investigue las diferentes formas de lograr la conversión. 
Muestre por pantalla el resultado de las conversiones.
 */
package Ejercicio01;
/**
 *
 * @author Bruno
 */
import java.util.Scanner;


public class Ejercicio1 {

    public static void main(String[] args) {
       
       
        
        
        System.out.println("Ingrese un número decimal");
        Scanner teclado = new Scanner (System.in);        
        double valorDecimal = teclado.nextDouble();
        System.out.println("Su número es: "+valorDecimal);
        
    
        float flotante = (float) valorDecimal;
        System.out.println("Su variable en flotante es: " + flotante);
        
        int entero =  (int) valorDecimal;
        System.out.println("Su variable en entero es: " + entero);
        
        short corto = (short) valorDecimal;
        System.out.println("Su variable en corto es: "+ corto);
        
        long largo = (long) valorDecimal;
        System.out.println("Su variable en largo es: "+largo);
        
        String cadena = Double.toString(valorDecimal);
        System.out.println("Su variable a una cadena es: " + cadena);
        
    }
    
}
