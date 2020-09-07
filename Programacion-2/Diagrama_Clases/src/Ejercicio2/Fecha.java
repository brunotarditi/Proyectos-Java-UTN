package Ejercicio2;

/**
 *
 * @author Bruno Tarditi
 */
public class Fecha {

    //Atributos
    private int dia;
    private int mes;
    private int anio;

    //Constructor vacío
    public Fecha() {

    }

    //Constructor sobrecargado
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    //Get and Set
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}
