package array_list;

import java.util.ArrayList;
import java.util.Scanner;

/*
2.(NumMayoPrimo.java) Leer 10 enteros, almacenarlos en un arreglo
y determinar en qué posición del arreglo está el mayor número primo leído.

 */
/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_2 {

    public static void main(String[] args) {

        ArrayList<Integer> arreglo = new ArrayList<>();
        int posicion = 0;
        int primoMayor = 0;

        System.out.println("Ingrese los 10 números enteros al arreglo: ");
        for (int i = 0; i < 10; i++) {
            int elementos = new Scanner(System.in).nextInt();
            arreglo.add(elementos);

            if (esPrimo(arreglo.get(i)) == true) {

                if (arreglo.get(i) > primoMayor) {
                    primoMayor = arreglo.get(i);
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
