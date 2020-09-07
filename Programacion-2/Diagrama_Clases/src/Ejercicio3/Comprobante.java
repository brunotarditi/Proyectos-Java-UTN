package Ejercicio3;

/**
 *
 * @author Bruno Tarditi
 */
public class Comprobante {

    //atributo
    private char tipo;
    private int numero;
    private Fecha fecha = new Fecha();

    //Constructor vacío
    public Comprobante() {
    }

    //Constructor sobrecargado
    public Comprobante(char tipo, int numero) {
        this.tipo = tipo;
        this.numero = numero;

    }

    //Get and Set
    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

}
