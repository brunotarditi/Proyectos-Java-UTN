/*
Realice una búsqueda secuencial en un arreglo unidimensional de tamaño 50 generado aleatoriamente mediante la función java random.
Realice una búsqueda secuencial de la siguiente forma:
- se lee el valor que se desea buscar,
- se compara la primera posición;
- si son iguales,
- fin de la búsqueda.
UTN-FRM
Arreglos de Una Dimensión.
- De lo contrario, compararlo con la segunda posición, y así sucesivamente.
- Si se llega al final del arreglo y no se encontró el valor, debe indicarlo con un mensaje apropiado.
- Si se encuentra, se debe especificar la posición que ese valor ocupa en el arreglo por primera vez.
 */
package Ejercicio06;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio06 {


    public static void main(String[] args) {
      
        int numeros [] = new int [50];
        for (int i = 0; i < numeros.length; i++) {
            int numRandom = (int)Math.floor((Math.random() *100)*100)/100;
            numeros[i]=numRandom;
            
        }
        
        System.out.println("Ingrese el número a buscar: ");
        int buscarNro = new Scanner(System.in).nextInt();
        int posicion = -1;
        for (int i = 0; i < numeros.length; i++) {
            if (buscarNro == numeros[i]) {
                posicion = i;
            }
            
            
        }
        
        if (posicion >= 0) {
            System.out.println("El número " + buscarNro + " fue encontrado en la posición "+posicion);
        } else{
            
            System.out.println("EL número " + buscarNro + " no se encontró");
        }
            
            muestroArreglo(numeros);
        }
        
        private static void muestroArreglo(int [] arreglo){
            
            String cadena = ", ";
            
            for (int i = 0; i < arreglo.length; i++) {
                if (i > 0) {
                    cadena+= ", ";
                }
                      cadena += (arreglo[i]);
                
            }
              System.out.println("valores: "+ cadena);
        }
        
    
    
}
