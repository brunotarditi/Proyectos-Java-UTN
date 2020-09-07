/*
 Crea un array o arreglo unidimensional con un tamaño de 5, 
 asignale los valores numéricos manualmente (los que tú quieras) 
 y muestralos por pantalla. Solicite los números mediante un bucle.
 */
package Ejercicio02;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio02 {


    public static void main(String[] args) {

        int numeros [] = new int [5];
        for (int i = 0; i < numeros.length; i++) {
        System.out.println("Ingrese un número: ");
        numeros[i] = new Scanner (System.in).nextInt();
            
        }
        
        System.out.println("Los números son: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
            
        }
    }
    
}
