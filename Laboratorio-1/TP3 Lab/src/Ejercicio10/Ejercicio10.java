/*
Dados 2 array de enteros, el primero de tamaño 5 y el segundo de tamaño 10, pedir los valores numéricos 
enteros para cargar cada uno de los arreglos, cree un tercer arreglo de tamaño 10 que contenga en casa 
posición la suma de la multiplicación de cada elemento del array uno por cada elemento del array 2
ARRAY3 = (posición 0 del arreglo 1 * posición 0 del arreglo 2)
+ (posición 0 del arreglo 1 * posición 1 del arreglo 2) 
+ (posición 0 del arreglo 1 * posición 2 del arreglo 2) 
+ ………….+ (posición 4 del arreglo 1 * posición 9 del arreglo 2)
Use 2 estructuras iterativas anidadas para realizar el cálculo y asignación de los valores en el 3 array.
 */
package Ejercicio10;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio10 {

   
    public static void main(String[] args) {
        
        int arreglo1 [] = new int [5];
        int arreglo2 [] = new int [10];
        int arreglo3 [] = new int [5];
        
        System.out.println("Ingrese 5 valores enteros para Arreglo1: ");
        for (int i = 0; i < arreglo1.length; i++) {
        arreglo1 [i] = new Scanner(System.in).nextInt();}
        
        System.out.println("Ingrese 10 valores enteros para Arreglo2: ");
        for (int i = 0; i < arreglo2.length; i++) {
        arreglo2 [i] = new Scanner(System.in).nextInt();}
        
        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = 0; j < arreglo2.length; j++) {
             arreglo3 [i] += arreglo1 [i] * arreglo2 [j];}
        }  
        
        System.out.print("Los resultados contenidos en Arreglo3 son: ");
        for (int i = 0; i < arreglo3.length; i++) {
        System.out.print(arreglo3 [i]+", ");   
        }
    }
    
}
