package array_list;

import java.util.ArrayList;
import java.util.Scanner;

/*
4.(NumTerminados4.java) Leer 10 números enteros, almacenarlos en un arreglo 
y determinar en qué posiciones se encuentran los números terminados en 4.
 */
/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_4 {

    public static void main(String[] args) {
        ArrayList<Integer> arreglo = new ArrayList<>();
        String cuatro = "";

        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < 10; i++) {
            int elementos = new Scanner(System.in).nextInt();
            arreglo.add(elementos);
            if (String.valueOf(arreglo.get(i)).endsWith("4")) {
                cuatro += String.valueOf("\n" + arreglo.get(i));
            }

        }
        System.out.println("Los números que terminan en '4': " + cuatro);
    }
}
