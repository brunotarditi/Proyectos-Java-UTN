/*
 3-Codifique un algoritmo que solicite el ingreso de un numero de 3 dígitos (100 - 999) y por 
medio del uso de las operaciones matemáticas módulo 10 y división 
por 10 efectué la suma de los 3 dígitos del número. Ejemplo ingreso 563, salida del algoritmo 14.
 */
package Ejercicio03;

/**
 *
 * @author Bruno
 */
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        System.out.println("Ingrese un número de 3 dígitos");
        int digitos = new Scanner(System.in).nextInt();

        while (digitos < 100 || digitos > 999) {
            System.out.println("Incorrecto, ingrese un número de 3 dígitos");
            digitos = new Scanner(System.in).nextInt();
        }

        int resultado = digitos % 10;
        int resultado1 = (digitos / 10) % 10;
        int resultado2 = (digitos / 10) / 10;
        int a = resultado + resultado1 + resultado2;

        System.out.println("El resultado es: " + a);

    }

}
