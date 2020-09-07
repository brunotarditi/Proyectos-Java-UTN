package Ejercicio5;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Auto extends Vehiculo {

    //atributo constante
    public static final int NRUEDAS = 4;

    public Auto(){
        
    }

    public Auto(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }
    
    @Override
    public void romperInercia(){
        System.out.println("Auto rompe la inercia.");
    }
    
}
