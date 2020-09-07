package array_list;

import java.util.ArrayList;
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

        ArrayList<Integer> arreglo = new ArrayList<>();
        int mayor = 0;
        int repetir = 0;

        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < 10; i++) {
            int elementos = new Scanner(System.in).nextInt();
            arreglo.add(elementos);
            if (arreglo.get(i) > mayor) {
                mayor = arreglo.get(i);
            }
        }

        for (int i = 0; i < 10; i++) {
            if (arreglo.get(i) == mayor) {
                repetir++;
            }
        }
        System.out.println("El mayor es: " + mayor + " y se repite: " + repetir);
    }
}
