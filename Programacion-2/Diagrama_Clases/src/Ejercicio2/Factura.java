package Ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author Bruno Tarditi
 */
public class Factura extends Comprobante {

    //atributos
    private float total;
    private Cliente mCliente;
    private ArrayList<Producto> mProducto = new ArrayList<>();

    //Contructor vacío
    public Factura() {

    }

    //Constructor sobrecargado
    public Factura(float total, Cliente mCliente, char tipo, int numero, Fecha fecha) {
        super(tipo, numero, fecha);
        this.total = total;
        this.mCliente = mCliente;

    }

    //Get and Set
    public Cliente getCliente() {
        return mCliente;
    }

    public void setCliente(Cliente cliente) {
        this.mCliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<Producto> getProducto() {
        return mProducto;
    }

    public void setProducto(ArrayList<Producto> mProducto) {
        this.mProducto = mProducto;
    }

}
