/*
Codifique 5 funciones java que resuelvan las operaciones matemáticas:
Suma +
Resta –
Multiplicación *
División /
Modulo %
Aplicadas sobre 2 números decimales.
Posteriormente codifique un programa que solicite el ingreso por parte del usuario de 2
números decimales y una vez ingresados le pregunte qué operación quiere realizar:
a- Suma +
b- Resta –
c- Multiplicación *
d- División /
e- Modulo %
En caso de que no ingrese ninguna de las opciones permitidas emita el mensaje “La opción
ingresada no es válida” y vuelva nuevamente a preguntarle qué operación matemática
quiere ejecutar. Si la opción es válida envié los números decimales ingresados por el
usuario a la función que corresponda y retorne el resultado de la operación. Finalmente
muestre un mensaje indicando el resultado de la operación realizada.
 */
package Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        double resultado = 0;
        boolean salir = false;

        System.out.println("Ingrese el primer numero");
        double num1 = new Scanner(System.in).nextInt();
        System.out.println("Ingrese el segundo numero");
        double numero2 = new Scanner(System.in).nextInt();

        do {

            System.out.println("Ingresó " + num1 + " y " + numero2);
            System.out.println("Ingrese la operacion a realizar.");
            System.out.println("Para salir, aprete 'n'.");
            System.out.println("a)Suma.");
            System.out.println("b) Resta.");
            System.out.println("c) Multiplicacion.");
            System.out.println("d) Division.");
            System.out.println("e) Modulo.");
            System.out.println("n) Salir.");

            String operacion = new Scanner(System.in).nextLine();

            switch (operacion) {

                case "a":
                    resultado = suma(num1, numero2);
                    break;
                case "b":
                    resultado = resta(num1, numero2);
                    break;
                case "c":
                    resultado = multiplicacion(num1, numero2);
                    break;
                case "d":
                    resultado = division(num1, numero2);
                    break;
                case "e":
                    resultado = modulo(num1, numero2);
                    break;
                case "n":
                    salir = true;
                    break;
                default:

                    System.out.println("La opción ingresada no es válida");
                    break;
            }

        } while (!salir);

        System.out.println("el resultado es " + resultado);

    }

    private static double suma(double a, double b) {
        return (a + b);
    }

    public static double resta(double a, double b) {
        return (a - b);
    }

    public static double multiplicacion(double a, double b) {
        return (a * b);
    }

    public static double division(double a, double b) {
        return (a / b);
    }

    public static double modulo(double a, double b) {
        return (a % b);

    }
}
