package map_list;

import java.util.HashMap;
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

        HashMap<Integer, Integer> mapa = new HashMap<>();
        int primoMayor = 0;
        int posicion = 0;

        
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese la clave: ");
            int clave = new Scanner(System.in).nextInt();
            System.out.print("Ingrese el valor: ");
            int valor = new Scanner(System.in).nextInt();
            
            mapa.put(clave, valor);
            
            
            if (esPrimo(mapa.getOrDefault(clave, valor)) == true) {

                if (mapa.getOrDefault(clave, valor) > primoMayor) {
                    primoMayor = mapa.getOrDefault(clave, valor);
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
