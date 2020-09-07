package Ejercicio5;

/**
 *
 * @author Bruno Tarditi
 */
public class FordFalcon extends Auto {

    public FordFalcon() {
    }

    public FordFalcon(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }

    public static int getNRUEDAS() {
        return NRUEDAS;
    }
    
    @Override
    public void romperInercia(){
        System.out.println("Ford Falcon rompe la inercia.");
    }
    

}
