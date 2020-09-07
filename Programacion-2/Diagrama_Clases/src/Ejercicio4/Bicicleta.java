package Ejercicio4;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Bicicleta extends Vehiculo {

    public Bicicleta() {

    }

    //Constructor sobrecargado 
    public Bicicleta(int ruedas, String duenio) {
        super(ruedas, duenio);
    }

    //Métodos implementados
    @Override
    public int getRuedas() {
        return ruedas;
    }

    @Override
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public double precio() {
        System.out.println("Ingrese el valor de la bicicleta: ");
        double val = new Scanner(System.in).nextDouble();
        return val;
    }

    @Override
    public double velocidad_max() {
        return 30;
    }

}
