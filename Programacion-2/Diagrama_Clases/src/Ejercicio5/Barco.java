package Ejercicio5;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Barco extends Vehiculo {

    public Barco(){
        
    }

    public Barco(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }
    @Override
    public void romperInercia(){
        System.out.println("Barco rompe la inercia de manera más lenta.");
    }
    
}
