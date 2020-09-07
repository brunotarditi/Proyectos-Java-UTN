package Ejercicio5;

/**
 *
 * @author Bruno Tarditi
 */
public class HondaXR600 extends Moto {

    public HondaXR600() {
    }

    public HondaXR600(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }

    public void esquivarObstaculos(int metros) {

        System.out.println("Esquivar charcos.");
    }

    public int getNRUEDAS() {
        return NRUEDAS;
    }
    
    
}
