/*
Escriba una aplicación para almacenar en un ArrayList<Integer> aleatoriamente 20 
números enteros positivos pares del 1 al 100, de los cuales se desea saber:
a) su promedio aritmético
b) cuántos de los números son iguales al promedio aritmético
c) cuántos de los números son mayores que el promedio aritmético
d) cuántos de los números son menores que el promedio aritmético
 */
package Ejercicio03;

import java.util.*;

/**
 *
 * @author Bruno
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        int suma = 0;
        int mayor = 0;
        int menor = 0;
        int igual = 0;
        List numeros = new ArrayList();
        for (int i = 0; i < 20; i++) {
            int randomNum = (int) (Math.random() * 100 + 1);
            numeros.add(randomNum);
            suma += (int) numeros.get(i);
        }

        int promedio = suma / 20;

        for (int i = 0; i < 20; i++) {
            if (promedio == (int) numeros.get(i)) {
                igual++;
            }
            if (promedio > (int) numeros.get(i)) {
                menor++;
            }
            if (promedio < (int) numeros.get(i)) {
                mayor++;
            }

        }

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("Los números aleatorios son: " + numeros);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("\nEl promedio es: " + promedio);
        System.out.println("");
        System.out.println("La cantidad de números iguales al promedio aritmético son → " + igual);
        System.out.println("");
        System.out.println("La cantidad de números mayores al promedio aritmético son → " + mayor);
        System.out.println("");
        System.out.println("La cantidad de números menores al promedio aritmético son → " + menor);
    }

}
