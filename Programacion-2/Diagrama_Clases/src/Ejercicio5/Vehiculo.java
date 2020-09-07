package Ejercicio5;

import java.util.ArrayList;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Vehiculo implements Desplazable {

    //atributos
    private double velocidadPromedio;
    private int velocidadMaxima;
    private ArrayList<Rueda> rueda = new ArrayList<>();

    //Constructor vacío
    public Vehiculo() {

    }

    //Constructor sobrecargado
    public Vehiculo(double velocidadPromedio, int velocidadMaxima) {
        this.velocidadPromedio = velocidadPromedio;
        this.velocidadMaxima = velocidadMaxima;
    }

    //Get and Set
    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public ArrayList<Rueda> getRueda() {
        return rueda;
    }

    public void setRueda(ArrayList<Rueda> rueda) {
        this.rueda = rueda;
    }

    public abstract void romperInercia();

    //Implementa de la interface Motor
    @Override
    public void esquivarObstaculo() {

    }

}
