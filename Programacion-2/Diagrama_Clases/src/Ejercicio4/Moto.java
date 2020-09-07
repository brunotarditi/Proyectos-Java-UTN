package Ejercicio4;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Moto extends Vehiculo implements Motor {

    public Moto() {

    }

    //Constructor sobrecargado
    public Moto(int ruedas, String duenio) {
        super(ruedas, duenio);
    }

    //Métodos implementados
    @Override
    public String tipo() {

        String o;
        System.out.println("Según los cilindros");
        System.out.println("1. Motor monocilíndrico");
        System.out.println("2. Motor bicilíndrico");
        System.out.println("3. Motor tricilíndrico");
        System.out.println("4. Motor tetracilíndrico");
        System.out.println("5. Motor hexacilíndrico");
        System.out.print("Digite el número de las opciones: ");
        o = new Scanner(System.in).nextLine();
        switch (o) {
            case "1":
                System.out.println("Motor sencillo, cuenta con un solo cilindro. Son generalmente los más económicos.");
                break;
            case "2":
                System.out.println("Combinación muy equilibrada, consiguen una mayor potencia y un menor número de vibraciones.");
                break;
            case "3":
                System.out.println("Consiguen una rápida potencia, sin que haya que esperar a las más altas revoluciones.");
                break;
            case "4":
                System.out.println("Son grandes y pesados comparados con los motores de dos cilindros, pero la finura de su funcionamiento hace que las vibraciones sean prácticamente inexistentes.");
                break;
            case "5":
                System.out.println("Se caracterizan por ofrecer una suavidad fuera de lo normal, muy potentes. Su precio es muy elevado.");
                break;

        }
        return o;
    }

    @Override
    public double precio() {
        System.out.println("Ingrese el valor de la moto: ");
        double val = new Scanner(System.in).nextDouble();
        return val;
    }

    @Override
    public double velocidad_max() {
        return 180;
    }

    @Override
    public int getRuedas() {
        return ruedas;
    }

    @Override
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

}
