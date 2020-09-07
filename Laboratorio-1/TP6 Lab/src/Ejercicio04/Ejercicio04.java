/*
Realice una búsqueda secuencial en un ArrayList<Integer> que contenga 50 elementos generados 
aleatoriamente mediante la función java random.
Realice una búsqueda secuencial de la siguiente forma:
- se lee el valor que se desea buscar,
- se compara la primera posición;
- si son iguales,
- fin de la búsqueda.
- De lo contrario, compararlo con la segunda posición, y así sucesivamente.
- Si se llega al final del arreglo y no se encontró el valor, debe indicarlo con un mensaje apropiado.
- Si se encuentra, se debe especificar la posición que ese valor ocupa en la lista por primera vez.
 */
package Ejercicio04;

import java.util.*;

/**
 *
 * @author Bruno
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        List elementos = new ArrayList();
        for (int i = 0; i < 50; i++) {
            int randomNum = (int) (Math.random() * 50 + 1);
            elementos.add(randomNum);
        }

        System.out.println("Ingrese el número que desea buscar: ");
        int buscarNro = new Scanner(System.in).nextInt();
        int posicion = -1;
        for (int i = 0; i < 50; i++) {
            if (buscarNro == (int) elementos.get(i)) {
                posicion = i + 1;
                break;
            }
        }
        System.out.println(elementos);
        if (posicion >= 0) {
            System.out.println("El número " + buscarNro + " fue encontrado en la posición → " + posicion);
        } else {
            System.out.println("El número " + buscarNro + " no se ha encontrado.");
        }

    }

}
