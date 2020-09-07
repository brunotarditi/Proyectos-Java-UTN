/*
Escriba una aplicación que solicite y cargue en un arreglo 10 dígitos enteros, 
luego cree dos nuevos arreglos y asigne al primero los números ingresados 
por el usuario de forma ascendente y en el segundo de forma descendente. 
Muestre los 2 arreglos por pantalla.
 */
package Ejercicio07;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio07 {

  
    public static void main(String[] args) {
      
        int arreglo [] = new int [10];
        int arregloAscendente [] = new int [10];
        int arregloDescendente [] = new int [10];
        for (int i=0; i < arreglo.length;i++) {
            System.out.println("Cargue 10 números: °"+ (i+1));
            arreglo [i] = new Scanner(System.in).nextInt();}
        
        
        /* el método sort de la clase Arrays, que está en el paquete java.util 
        se encargará de ordenar cualquier tipo de array que le pasemos como argumento.*/
            Arrays.sort(arreglo);
            for (int i = 0; i < 10; i++) {
            arregloAscendente[i] = arreglo[i];
        }
        int contador = 0;
        for (int j = 9; j >= contador; j--) {
            System.out.println("Número: "  + arregloAscendente[j]);
            arregloDescendente[contador] = arregloAscendente[j];    
            contador++;
        
        }
 
         System.out.println("Los números cargados de forma ascendente son: "+ Arrays.toString(arregloAscendente));
         System.out.println("Los números cargados de forma descentes son: "+ Arrays.toString(arregloDescendente));  
        
    }
    
}
