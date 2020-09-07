package map_list;

import java.util.HashMap;
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

        HashMap<Integer, Integer> mapa = new HashMap<>();
        int mayor = 0;
        int repetir = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese la clave: ");
            int clave = new Scanner(System.in).nextInt();
            System.out.print("Ingrese el valor: ");
            int valor = new Scanner(System.in).nextInt();
            mapa.put(clave, valor);

            if (mapa.getOrDefault(clave, valor) > mayor) {
                mayor = mapa.getOrDefault(clave, valor);
            }

            if (mapa.getOrDefault(clave, valor) == mayor) {
                repetir++;
            }
        }

        System.out.println("El mayor es: " + mayor + " y se repite: " + repetir);
    }
}
