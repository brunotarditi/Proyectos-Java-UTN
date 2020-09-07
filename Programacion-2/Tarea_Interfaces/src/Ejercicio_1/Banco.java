package Ejercicio_1;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */

//Clase abstracta Banco implementa la interface Dinero
public abstract class Banco implements Dinero {

    @Override
    public abstract void pagar();

    @Override
    public abstract void cobrar();

    @Override
    public abstract double depositar(double efectivo);

}
//Clases hijas de Banco
class Galicia extends Banco {

//Métodos implementados
    @Override
    public void pagar() {

        System.out.println("Pagar impuestos en banco Galicia.");

    }

    @Override
    public void cobrar() {

        System.out.println("Extraer dinero de cajero bancario Galicia.");

    }

    @Override
    public double depositar(double efectivo) {

        System.out.println("\nBienvenido a deposito virtual del banco Galicia.\n");

        double total_ingresado = 0;

        while (true) {

            System.out.println("Ingrese el monto a depositar y aprete 0 para finalizar: ");
            efectivo = new Scanner(System.in).nextDouble();

            if ((efectivo <= 10000) && (efectivo >= 1)) {
                System.out.println("Ha depositado $ " + efectivo + " pesos.");
                total_ingresado += efectivo;
                System.out.println("Lleva un total de $ " + total_ingresado + " ingresado.");

            } else {
                System.out.println("No puede depositar más de 10000 pesos y menos de 1 peso.");
            }
            if (efectivo == 0) {
                System.out.println("Adios.");
                break;
            }
        }

        System.out.println("\nEl total depositado $ " + total_ingresado + " pesos.");
        return total_ingresado;

    }
}

class Santander extends Banco {

//Métodos implementados
    @Override
    public void pagar() {

        System.out.println("Pagar impuestos en banco Santander.");

    }

    @Override
    public void cobrar() {

        System.out.println("Extraer dinero de cajero bancario Santander.");

    }

    @Override
    public double depositar(double efectivo) {

        System.out.println("Bienvenido a deposito virtual del banco Santander.");

        double total_ingresado = 0;

        while (true) {

            System.out.print("Ingrese el monto a depositar y aprete 0 para finalizar: ");
            efectivo = new Scanner(System.in).nextDouble();

            if ((efectivo <= 10000) && (efectivo >= 1)) {
                System.out.println("Ha depositado $ " + efectivo + " pesos.");
                total_ingresado += efectivo;
                System.out.println("Lleva un total de $ " + total_ingresado + " ingresado.");

            } else {
                System.out.println("No puede depositar más de 10000 pesos y menos de 1 peso.");
            }

            if (efectivo == 0) {
                System.out.println("\nAdiós.");
                break;
            }

        }

        System.out.println("El total depositado $ " + total_ingresado + " pesos.");
        return total_ingresado;
    }

}
