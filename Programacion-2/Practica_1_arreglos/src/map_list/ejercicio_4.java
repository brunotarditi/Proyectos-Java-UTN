package map_list;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_4 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> mapa = new HashMap<>();
        String cuatro = "";

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese la clave: ");
            int clave = new Scanner(System.in).nextInt();
            System.out.print("Ingrese el valor: ");
            int valor = new Scanner(System.in).nextInt();

            mapa.put(clave, valor);

            if (String.valueOf(mapa.getOrDefault(clave, valor)).endsWith("4")) {
                cuatro += String.valueOf("\n" + mapa.getOrDefault(clave, valor));
            }

        }
        System.out.println("Los números que terminan en '4': " + cuatro);
    }
}
