package arreglos;

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

        int[] arreglo = new int[10];
        String cuatro = "";

        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < arreglo.length; i++) {           
            arreglo[i] = new Scanner(System.in).nextInt();
            if (String.valueOf(arreglo[i]).endsWith("4")) {
                cuatro += String.valueOf("\n" + arreglo[i]);
            }

        }
        System.out.println("Los números que terminan en '4': " + cuatro);

    }

}
