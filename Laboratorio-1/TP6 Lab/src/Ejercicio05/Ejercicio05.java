/*
Escriba una aplicación que solicite y cargue en una ArrayList<Integer> 10 dígitos 
enteros, luego cree dos nuevas ArrayList<Integer> y asigne a la primera los números 
ingresados por el usuario de forma ascendente y en la segunda de forma descendente. 
Muestre las 2 listas por pantalla. Investigue como ordenar una Lista(List<>)
 */
package Ejercicio05;

import java.util.*;

/**
 *
 * @author Bruno
 */
public class Ejercicio05 {

    public static void main(String[] args) {

        List digitos = new ArrayList();
        for (int i = 0; i < 10; i++) {
            System.out.println("------------------------------");
            System.out.println("Introduzca 10 números: ");
            System.out.println("------------------------------");
            int numeros = new Scanner(System.in).nextInt();
            digitos.add(numeros);
        }
        System.out.println("");
        System.out.println("La lista original es: " + digitos);
        Collections.sort(digitos);
        System.out.println("La lista ordenada de forma ascendente es: " + digitos);
        Collections.sort(digitos, Collections.reverseOrder());
        System.out.println("La lista ordenada de forma descendente es: " + digitos);

        
        /* el método sort de la clase Arrays, que está en el paquete java.util 
        que se encargará de ordenar cualquier tipo de array que le pasemos como argumento.*/

    }
}
