package Ejercicio_2;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        Aula a1 = new Aula();
        hazloSentar(a1);

        System.out.println("");
        Tractor t1 = new Tractor();
        hazloSentar(t1);

        Bicicleta b1 = new Bicicleta();
        hazloSentar(b1);

        Scanner color = new Scanner(System.in);
        Camioneta c1 = new Camioneta();
        hazloSentar(c1);
        System.out.print("Ingrese el color de la camioneta: ");
        c1.setColor(color.nextLine());
        System.out.println("Es de color " + c1.getColor());

    }

    static void hazloSentar(Asiento asiento) {
        asiento.sentarse();
    }

}
