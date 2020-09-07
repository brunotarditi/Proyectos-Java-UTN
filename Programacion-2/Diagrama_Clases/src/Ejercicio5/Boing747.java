package Ejercicio5;

/**
 *
 * @author Bruno Tarditi
 */
public class Boing747 extends Vehiculo {

    private static int viajes;

    public Boing747() {

    }

    public Boing747(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }

    public void despegar() {

        System.out.println("Despegando del aeropuerto de Mendoza.");
    }

    public void aterrizar() {

        System.out.println("Aterrizando en aeropuerto de Barajas de Madrid.");
    }

    public static void agregarViaje() {

        System.out.println("Viaje agregado con éxito.");

    }

    public static int getViajes() {
        return viajes;
    }

    public static void setViajes(int viajes) {
        Boing747.viajes = viajes;
    }

    @Override
    public void romperInercia(){
        System.out.println("Este avión rompe la inercia de manera muy sencilla.");
    }
}
