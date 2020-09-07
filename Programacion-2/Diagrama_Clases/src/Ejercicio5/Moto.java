package Ejercicio5;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Moto extends Vehiculo {

    //Atributo constante
    public final int NRUEDAS = 2;

    public Moto() {

    }

    public Moto(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }
    
    @Override
    public void romperInercia(){
        System.out.println("Moto rompe la inercia.");
    }

}
