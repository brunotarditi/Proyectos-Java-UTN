package Ejercicio5;

/**
 *
 * @author Bruno Tarditi
 */
public class HondaXR25 extends Moto {

    public HondaXR25() {
    }

    public HondaXR25(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }

    public void esquivarObstaculo(int metros) {

        System.out.println("Esquivar pozos.");

    }

    public int getNRUEDAS() {
        return NRUEDAS;
    }

}
