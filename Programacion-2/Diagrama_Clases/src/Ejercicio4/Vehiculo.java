package Ejercicio4;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Vehiculo {

    //atributos
    protected int ruedas;
    protected String duenio;

    public Vehiculo(){
        
    }
    //Constructor sobrecargado
    public Vehiculo(int ruedas, String duenio) {
        this.ruedas = ruedas;
        this.duenio = duenio;
    }

    //Métodos abstractos
    public abstract double precio();

    public abstract double velocidad_max();

    public abstract int getRuedas();

    public abstract void setRuedas(int ruedas);

    //Get and Set de dueño
    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

}
