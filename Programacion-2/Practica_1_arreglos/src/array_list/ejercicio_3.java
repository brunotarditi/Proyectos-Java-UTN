package array_list;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<Integer> arreglo = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            generarAleatorio(arreglo);
            burbuja(arreglo);
        }

        int elemento = 241;
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.println("Posición " + i + " = " + arreglo.get(i));
        }

        int encontrado = Arrays.binarySearch(arreglo.toArray(), elemento);
        
        if (encontrado >= 0 && encontrado <= 9) {
            System.out.println("Encontrado en la posición: " + encontrado);
        }else{
            System.out.println("No fue encontrado.");
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

    public static ArrayList<Integer> generarAleatorio(ArrayList<Integer> arreglo) {

        int i = 10;

        while (i != arreglo.size()) {
            int aleatorio = (int) (Math.random() * 200) + 100;
            if (esPrimo(aleatorio) == true) {
                arreglo.add(aleatorio);
            }
        }

        return arreglo;
    }

    private static ArrayList<Integer> burbuja(ArrayList<Integer> A) {

        int n = A.size();
        boolean intercambiando;
        do {

            intercambiando = false;
            for (int i = 1; i < n; i++) {
                if (A.get(i - 1) > A.get(i)) {
                    int aux = A.get(i);
                    A.set(i, A.get(i - 1));
                    A.set(i - 1, aux);
                    intercambiando = true;
                }
            }
        } while (intercambiando);

        return A;
    }

}
