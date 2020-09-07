package arreglos;

/*
2.(NumMayoPrimo.java) Leer 10 enteros, almacenarlos en un arreglo
y determinar en qué posición del arreglo está el mayor número primo leído.

 */
import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_2 {

    public static void main(String[] args) {

        int[] arreglo = new int[10];
        int posicion = 0;
        int primoMayor = 0;
        String noPrimo = "";

        System.out.println("Ingrese los 10 números enteros al arreglo: ");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new Scanner(System.in).nextInt();

            if (esPrimo(arreglo[i]) == true) {
                if (arreglo[i] > primoMayor) {
                    primoMayor = arreglo[i];
                    posicion = i;
                }
            }

        }

        System.out.println("El número primo mayor es: " + primoMayor + " en la posición: " + posicion);

    }

    public static boolean esPrimo(int numero) {

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;

    }

}
