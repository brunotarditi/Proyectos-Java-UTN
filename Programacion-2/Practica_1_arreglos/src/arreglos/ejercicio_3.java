package arreglos;

import java.util.Arrays;

/*
3.(NumPrimos2.java) Almacenar en un arreglo de 10 posiciones los 10 
números primos comprendidos entre 100 y 300. Luego mostrarlos en pantalla.
 */
/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_3 {

    public static void main(String[] args) {

        int[] arreglo = new int[10];

        for (int i = 0; i < arreglo.length; i++) {
            generarAleatorio(arreglo);
        }
        quickSort(arreglo, 0, arreglo.length - 1);

        int elemento = 241; // es el que quiero encontrar
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Posición " + i + " = " + arreglo[i]);

        }
        int encontrado = Arrays.binarySearch(arreglo, elemento);

        if (encontrado >= 0 && encontrado <= 9) {
            System.out.println("Encontrado en la posición: " + encontrado);
        } else {
            System.out.println("El número no fue encontrado");
        }

    }

    public static boolean esPrimo(int numero) {

        for (int i = 2; i < numero; i++) {

            if (numero % i == 0) {
                return false;
            }

        }
        return true;
    }

    public static int[] generarAleatorio(int[] arreglo) {

        int i = 0;

        while (i != arreglo.length) {
            int aleatorio = (int) (Math.random() * 200) + 100;
            if (esPrimo(aleatorio) == true) {
                arreglo[i] = aleatorio;
                i++;
            }
        }

        return arreglo;
    }

    public static void quickSort(int A[], int izq, int der) {
        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {// mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (A[j] > pivote) {
                j--;// busca elemento menor que pivote
            }
            if (i < j) {// si no se han cruzado                      
                aux = A[i];// los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quickSort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quickSort(A, j + 1, der); // ordenamos subarray derecho
        }
    }

}
