/*
Dada las siguientes matrices 
int[] pares = {6, 10, 2, 8, 4};
int[] impares = {7, 9, 5, 1, 3};
Mediante el uso de instrucciones de iteración, recorra ambas matrices y cree una nueva
matriz ordenada que sea la combinación de ambas matrices, es decir la matriz resultante
debería ser
int[] números = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
Aplique alguno de los algoritmos fundamentales de ordenamiento para ordenar el array.
 */
package Ejercicio02;

/**
 *
 * @author Bruno
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        int[] pares = {6, 10, 2, 8, 4};
        int[] impares = {7, 9, 5, 1, 3};
        int[] resultante = new int[pares.length + pares.length];

        for (int i = 0; i < pares.length; i++) {
            resultante[i] = pares[i];
        }

        for (int i = pares.length; i < resultante.length; i++) {
            resultante[i] = impares[i - pares.length];
        }
        AlgoritmosFundamentales.quickSort(resultante, 0, resultante.length - 1);
        System.out.println("La matriz resultante es: ");
        for (int i = 0; i < resultante.length; i++) {
            System.out.print(resultante[i] + ", ");

        }

    }

}
