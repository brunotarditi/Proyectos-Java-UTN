/*
Crea un array o arreglo unidimensional donde tú le indiques el tamaño 
por teclado y crear una función que rellene el array o arreglo con los 
múltiplos de un numero pedido por teclado. Por ejemplo, si defino un 
array de tamaño 5 y elijo un 3 en la función, el array contendrá 3, 6, 9, 12, 15. 
Muéstralos por pantalla usando otra función distinta.
 */
package Ejercicio03;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio03 {


    public static void main(String[] args) {
        
        System.out.println("Indique el tamaño del array: ");
        int tamaño = new Scanner (System.in).nextInt();
        int [] array = new int [tamaño];
        
        rellenoArreglo(array);
        muestroArreglo(array);
        

    }
    
    //metodo para mostrar como rellenar un array con los multiplos de numeros pedidos por teclado
    private static void rellenoArreglo (int [] array){
    
        System.out.println("Ingrese el numero a multiplicar: ");
        int numero = new Scanner(System.in).nextInt();
        int tabla = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = numero * tabla;
            tabla++;
            
        }      
        
    }   
    //metodo para mostrar el array

    private static void muestroArreglo (int [] arreglos){

    String cadena = " ";
    
    for (int i = 0; i < arreglos.length; i++) {
            if (i > 0) {
                cadena += ",";
            }
         
            cadena += arreglos[i];
        }
        
            System.out.println("Valores: " + cadena);
    }
    
}
