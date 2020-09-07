package array_list;

import java.util.ArrayList;
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

        ArrayList<Integer> arreglo = new ArrayList<>();
        int mayor = 0;
        int posicion = 0;

        System.out.println("Ingrese números enteros al arreglo: ");
        for (int i = 0; i < 10; i++) {
            int elementos = new Scanner(System.in).nextInt();
            arreglo.add(elementos);

            if (arreglo.get(i) > mayor) {
                mayor = arreglo.get(i);
                posicion = i;
            }
        }
        System.out.println("El número más grande se encuentra en la posición: " + posicion + "\nY es el: " + mayor);
    }
}
