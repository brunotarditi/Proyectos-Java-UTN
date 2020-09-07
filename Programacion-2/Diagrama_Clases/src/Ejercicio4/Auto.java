package Ejercicio4;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Auto extends Vehiculo implements Motor {

    //atributo
    private int puerta;

    public Auto() {

    }

    //Constructor sobrecargado
    public Auto(int puerta, int ruedas, String duenio) {
        super(ruedas, duenio);
        this.puerta = puerta;
    }

    //Get and set de puerta
    public int getPuerta() {
        return puerta;
    }

    //métodos implementados
    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    @Override
    public double precio() {
        System.out.println("Ingrese el valor del auto: ");
        double val = new Scanner(System.in).nextDouble();
        return val;
    }

    @Override
    public double velocidad_max() {

        return 180;
    }

    @Override
    public String tipo() {
         String o;
        System.out.println("Según el tipo de combustible que utiliza");
        System.out.println("1. Nafta");
        System.out.println("2. Diesel");
        System.out.println("3. Gas");
        System.out.print("Digite el número de las opciones: ");
        o = new Scanner(System.in).nextLine();
        switch (o) {
            case "1":
                System.out.println("Utiliza la gasolina como su principal fuente de energía.");
                break;
            case "2":
                System.out.println("Utiliza diésel para su funcionamiento");
                break;
            case "3":
                System.out.println("Utiliza gas combustible para su funcionamiento");
                break;

        }
        return o;
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
