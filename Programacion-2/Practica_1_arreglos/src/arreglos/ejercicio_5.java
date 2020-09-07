package arreglos;

import java.util.Scanner;

/*
5.(RepeticionesNumMayor.java) Leer 10 números enteros, almacenarlos en un arreglo 
y determinar cuántas veces está repetido el mayor.
 */
/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_5 {

    public static void main(String[] args) {

        int[] arreglo = new int[10];
        int mayor = 0;
        int repetir = 0;

        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new Scanner(System.in).nextInt();
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
            }
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == mayor) {
                repetir++;
            }
        }
        System.out.println("El mayor es: " + mayor + " y se repite: " + repetir);

    }
}
