package map_list;

import java.util.HashMap;

/*
3.(NumPrimos2.java) Almacenar en un arreglo de 10 posiciones los 10 
números primos comprendidos entre 100 y 300. Luego mostrarlos en pantalla.
 */
/**
 *
 * @author Bruno Tarditi
 */
public class ejercicio_3 {

    public static void main(String[] args) {

        HashMap<Integer, Integer> mapa = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            generarAleatorio(mapa);
        }

        System.out.println(mapa.toString());
        burbuja(mapa);
        for (int i = 0; i < mapa.size(); i++) {
            System.out.println("Posición " + i + " = " + mapa.get(i));

        }

    }

    public static boolean esPrimo(int numero) {

        for (int i = 2; i < numero; i++) {

            if (numero % i == 0) {
                return false;
            }

        }
        return true;
    }

    public static HashMap<Integer, Integer> generarAleatorio(HashMap<Integer, Integer> mapa) {

        int i = 10;
        while (i != mapa.size()) {
            int clave = (int) (Math.random() * 10) + 0;
            int valor = (int) (Math.random() * 200) + 100;
            if (esPrimo(valor) == true) {
                mapa.put(clave, valor);
            }
        }

        return mapa;
    }

    private static HashMap burbuja(HashMap<Integer, Integer> A) {
        int n = A.size();
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 1; i < n; i++) {
                if (A.get(i - 1) > A.get(i)) {
                    int aux = A.get(i - 1);
                    A.put((i - 1), A.get(i));
                    A.put(i, aux);
                    intercambiado = true;
                }
            }
        } while (intercambiado == true);
        return A;
    }

}
