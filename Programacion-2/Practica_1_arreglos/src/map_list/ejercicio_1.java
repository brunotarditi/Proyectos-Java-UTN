package map_list;

import java.util.HashMap;
import java.util.Scanner;

/*
1.(NumMayor.java) Leer 10 enteros, almacenarlos en un arreglo 
y determinar en qué posición del arreglo está el mayor número leído.
 */
/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_1 {

    public static void main(String[] args) {

        HashMap<Integer, Integer> mapa = new HashMap<>();

        int mayor = 0;
        int posicion = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese clave: ");
            int clave = new Scanner(System.in).nextInt();
            System.out.print("Ingrese valor: ");
            int valor = new Scanner(System.in).nextInt();
               
            mapa.put(clave, valor);

            if (mapa.getOrDefault(clave, valor) > mayor) {
                mayor = mapa.getOrDefault(clave, valor);
                posicion = i;
            }
        }
        System.out.println("El número más grande se encuentra en la posición: " + posicion + "\nY es el: " + mayor);

    }

}
