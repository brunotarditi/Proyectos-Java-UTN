package Ejercicio3;

/**
 *
 * @author Bruno Tarditi
 */
public class Recibo extends Comprobante {

    //Atributos
    private Proveedor proveedor = new Proveedor();
    private float total;
    private String detalle;

    //Constructor vacío
    public Recibo() {
    }

    //Constructor sobrecargado
    public Recibo(float total, String detalle, char tipo, int numero) {
        super(tipo, numero);
        this.total = total;
        this.detalle = detalle;

    }

    //Get and Set
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
