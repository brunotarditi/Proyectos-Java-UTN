/*
Programar un algoritmo recursivo que en cada recursión multiplique a si mismo un
número ingresado por el usuario hasta que el valor resultante sea mayor
100.000.000. Valide que el número ingresado por el usuario sea mayor a 1, ejemplo:
Se ingresa el valor 6
1 iteración => 6 * 6 = 36
2 iteración => 36 * 36 = 1296
3 iteración => 1296 * 1296 = 1679616
4 iteración => 1679616 * 1679616 = 2821109907456



 */
package Ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        long r = 0;

        while (r <= 1) {

            System.out.println("Ingrese un número entero mayor a 1: ");
            r = new Scanner(System.in).nextLong();
        }
        multiplicacion(r);

    }

    //metodo que devuelve la multiplicación de un tipo de dato long
    public static long multiplicacion(long a) {

        long resultado;
        if (a > 100000000) {
            return a;
        } else {
            resultado = a * a;
            System.out.println(a + " * " + a + " = " + resultado);
        }
        return multiplicacion(resultado);
    }
}
