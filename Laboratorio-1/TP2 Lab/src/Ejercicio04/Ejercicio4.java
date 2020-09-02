/*
 4-Desarrolle un programa que ayude a una cajera a determinar el número de billetes y monedas 
que se necesitan de cada una de las siguientes denominaciones 200, 100, 50, 20, 10, 5, 2 y 1, y monedas 
de 0.50, 0.25, 0.10 y 0.05 centavos para una cantidad de dinero dada. Ejemplo si la cantidad es 1390,55 
se necesitan 6 billetes de 200, 1 billete de 100, 1 billete de 50, 2 billetes de 20, 1 moneda de 0.50 y 
una moneda de 0.05 centavos.  
 */
package Ejercicio04;

/**
 *
 * @author Bruno
 */
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        System.out.println("Ingrese la cantidad de dinero a cobrar: ");
        double monto = new Scanner(System.in).nextDouble();

        double resto200 = (monto % 200);
        double billetes200 = (monto - resto200) / 200;

        double resto100 = resto200 % 100;
        double billetes100 = (resto200 - resto100) / 100;

        double resto50 = resto100 % 50;
        double billetes50 = (resto100 - resto50) / 50;

        double resto20 = resto50 % 20;
        double billetes20 = (resto50 - resto20) / 20;

        double resto10 = resto20 % 10;
        double billetes10 = (resto20 - resto10) / 10;

        double resto5 = resto10 % 5;
        double billetes5 = (resto10 - resto5) / 5;

        double resto1 = resto5 % 1;
        double billete1 = (resto5 - resto1) / 1;

        double restomoneda50 = resto1 % 0.50;
        double moneda50 = (resto1 - restomoneda50) / 0.50;

        double restomoneda25 = restomoneda50 % 0.25;
        double moneda25 = (restomoneda50 - restomoneda25) / 0.25;

        double restomoneda10 = restomoneda25 % 0.10;
        double moneda10 = (restomoneda25 - restomoneda10) / 0.10;

        double restomoneda005 = restomoneda10 % 0.05;
        double moneda005 = (restomoneda10 - restomoneda005) / 0.05;

        System.out.println("Se necesitan: " + billetes200 + " billetes de 200");
        System.out.println("Se necesitan: " + billetes100 + " billetes de 100");
        System.out.println("Se necesitan: " + billetes50 + " billetes de 50");
        System.out.println("Se necesitan: " + billetes20 + " billetes de 20");
        System.out.println("Se necesitan: " + billetes10 + " billetes de 10");
        System.out.println("Se necesitan: " + billetes5 + " billetes de 5");
        System.out.println("Se necesitan: " + billete1 + " billetes de 1");
        System.out.println("Se necesitan: " + moneda50 + " moneda de 0.50");
        System.out.println("Se necesitan: " + moneda25 + " moneda de 0.25");
        System.out.println("Se necesitan: " + moneda10 + " moneda de 0.10");
        System.out.println("Se necesitan: " + moneda005 + " moneda de 0.05");

    }

}
