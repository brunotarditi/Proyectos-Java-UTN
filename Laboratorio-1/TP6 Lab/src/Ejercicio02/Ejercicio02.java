/*
Escriba una aplicación que:
a) lea 20 números decimales ingresados por teclado por el usuario y los coloque en un ArrayList<Integer>.
b) determine y muestre el mayor de los números en el arreglo
c) determine y muestre el menor de los números del arreglo 
calcule y muestre el rango (diferencia entre el mayor y el menor) de los elementos en el arreglo
 */
package Ejercicio02;

import java.util.*;

/**
 *
 * @author Bruno
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        double mayor = 0;
        double menor = 0;
        List numeros = new ArrayList();
        for (int i = 0; i < 20; i++) {
            System.out.println("Ingrese 20 números decimales");
            double ingresarNum = new Scanner(System.in).nextDouble();
            numeros.add(ingresarNum);

            if (i == 0) { //compara el indice con el valor ingresado por el usuario
                mayor = ingresarNum;
                menor = ingresarNum;
            }
            if (mayor < ingresarNum) {
                mayor = ingresarNum;
            }
            if (menor > ingresarNum) {
                menor = ingresarNum;
            }
        }
        System.out.println("----------------------------");
        System.out.println("La lista de números es\n" + numeros);
        System.out.println("----------------------------");
        System.out.println("El mayor es: " + mayor);
        System.out.println("El menor es: " + menor);
        System.out.println("La diferencia es: " + (mayor - menor));
    }

}
