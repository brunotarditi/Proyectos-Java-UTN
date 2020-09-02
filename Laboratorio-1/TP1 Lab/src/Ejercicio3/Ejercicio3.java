/*Codifique un programa de consola en Java que permita realizar las siguientes acciones:
Generar un número aleatorio entre 0 y 100, para ello use la siguiente función:
int x = new Double(Math.random() * 100).intValue();
Una vez generado el número codifique la lógica necesaria para encontrar el número aleatorio
ayudando al usuario informando al mismo si el número ingresado es mayor o menor al número 
aleatorio buscado. Una vez encontrado el número muestre la cantidad de intentos necesarios para lograrlo.*/
package Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        int contador = 0;

        int x = new Double(Math.random() * 100).intValue();
        System.out.println("Ingrese un número entre el 1 y 100: \n");
        int numero = new Scanner(System.in).nextInt();
        while (numero != x) {
            if (numero > x) {
                System.out.println("Es muy alto");
                System.out.println("Ingrese un número: ");
                numero = new Scanner(System.in).nextInt();
                contador++;
            } else {
                System.out.println("Es muy bajo");
                System.out.println("Ingrese un número: ");
                numero = new Scanner(System.in).nextInt();
                contador++;
            }
        }
        System.out.println("Correcto, número encontrado");
        System.out.println("Cantidad de intentos: " + contador);

    }

}
