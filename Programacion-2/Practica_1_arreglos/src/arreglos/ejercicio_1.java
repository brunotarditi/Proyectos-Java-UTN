package arreglos;

/*
1.(NumMayor.java) Leer 10 enteros, almacenarlos en un arreglo 
y determinar en qué posición del arreglo está el mayor número leído.
 */
import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_1 {

    public static void main(String[] args) {

        int[] arreglo = new int[10];
        int mayor = 0;
        int posicion = 0;

        System.out.print("Ingrese números enteros al arreglo: ");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new Scanner(System.in).nextInt();
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
                posicion = i;
            }
        }
        System.out.println("El número más grande se encuentra en la posición: " + posicion + "\nY es el: " + mayor);

    }

}
