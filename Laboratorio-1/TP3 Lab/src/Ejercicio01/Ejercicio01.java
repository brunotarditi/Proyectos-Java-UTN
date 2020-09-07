/*
1. ¿Qué sucede si tratamos de acceder un elemento fuera del tamaño del array?
*/

package Ejercicio01;



/**
 *
 * @author Bruno
 */
public class Ejercicio01 {


    public static void main(String[] args) {
        
        int [] arreglo = new int [5];
        System.out.println(arreglo[6]);
            
  
        }
    
    /*Se produce un error:
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 6
    y eso es porque la dimensión del arreglo es menor a la que se intenta acceder y 
    no puede retornar a un valor que no se encuentre en esa dimensión.
    */
        
    }
    

