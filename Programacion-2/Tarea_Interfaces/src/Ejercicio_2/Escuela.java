package Ejercicio_2;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
//Clase abstracta Escuela implementa la interface Asiento
public abstract class Escuela implements Asiento {

    @Override
    public abstract void sentarse();
}

class Aula extends Escuela {

    @Override
    public void sentarse() {

        System.out.println("El máximo de alumnos que podrán sentarse es de 30.");
        System.out.print("Ingrese el número de sillas que necesita para el aula: ");
        int num_silla = new Scanner(System.in).nextInt();

        if (num_silla <= 30 && num_silla > 0) {
            System.out.println("Podrán sentarse " + num_silla + " alumnos.");

        }
        if (num_silla <= 0) {
            System.out.println("Debe ingresar al menos una silla.");
            sentarse();

        }
        if (num_silla > 30) {
            System.out.println("Faltarán sillas.");
        }

    }
}
