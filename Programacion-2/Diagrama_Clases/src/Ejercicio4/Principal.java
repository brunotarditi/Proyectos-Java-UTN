package Ejercicio4;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Solicitar datos por teclado
        Scanner sc = new Scanner(System.in);

        //Objetos instanciados
        Bicicleta b1 = new Bicicleta();
        Auto a1 = new Auto();
        Moto m1 = new Moto();

        System.out.println("¿Cual es el dueño?: ");
        b1.setDuenio(sc.nextLine());
        System.out.println("¿Puertas?: ");
        a1.setPuerta(sc.nextInt());
        System.out.println("¿Ruedas?: ");
        m1.setRuedas(sc.nextInt());

        System.out.println("BICICLETA");
        System.out.println("Dueño de la bici: " + b1.getDuenio());

        System.out.println("AUTO");
        System.out.println(puertas(a1));

        System.out.println("MOTO");
        System.out.println("Ruedas de la moto: " + m1.getRuedas());

        System.out.println("TIPO DE MOTOR SEGÚN CARACTERÍSTICAS");
        System.out.println("MOTOS");
        tipo(m1);
        System.out.println("AUTOS");
        tipo(a1);

    }

    static String tipo(Motor t) {

        return t.tipo();
    }

    static String puertas(Auto n) {
        if (n.getPuerta() == 3) {
            return "Auto de 3 puertas";
        } else if (n.getPuerta() != 3 && n.getPuerta() != 5) {
            return "¡Error!, el auto no puede tener ese número de puertas.";
        } else {
            return "Auto de 5 puertas";
        }
    }
}
