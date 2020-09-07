package Ejercicio01;

/**
 *
 * @author Bruno
 */
public class AlgoritmosFundamentales {

    public static void insercion(int[] A) {

        for (int i = 1; i < A.length; i++) {
            int valor = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > valor) {

                A[j + 1] = A[j];
                j--;
            }

            A[j + 1] = valor;
        }
    }

    public static void burbuja(int[] A) {

        int n = A.length;
        boolean intercambiando;
        do {

            intercambiando = false;
            for (int i = 1; i < n; i++) {
                if (A[i - 1] > A[i]) {
                    int aux = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = aux;
                    intercambiando = true;
                }
            }
        } while (intercambiando);
    }

    public static void OrdenamientoPorSeleccion(int[] A) {

        int n = A.length;
        for (int i = 1; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minimo]) {
                    //minimo = j;
                    int aux = A[minimo];
                    A[minimo] = A[j];
                    A[j] = aux;
                }

            }

        }

    }

    public static void quickSort(int A[], int izq, int der) {
        int pivote = A[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (A[i] <= pivote && i < j) {
                i++;
            }
            while (A[j] > pivote) {
                j--;
            }
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j];
        A[j] = pivote;
        if (izq < j - 1) {
            quickSort(A, izq, j - 1);
        }
        if (j + 1 < der) {
            quickSort(A, j + 1, der);
        }
    }

}
