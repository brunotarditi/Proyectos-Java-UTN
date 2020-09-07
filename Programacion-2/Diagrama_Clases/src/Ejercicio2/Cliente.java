package Ejercicio2;

/**
 *
 * @author Bruno Tarditi
 */
public class Cliente {

    //atributos
    private int codigo;
    private String RazonSocial;

    //Constructor vacío
    public Cliente() {

    }

    //Constructor sobrecargado
    public Cliente(int codigo, String RazonSocial) {
        this.codigo = codigo;
        this.RazonSocial = RazonSocial;
    }

    //Get and Set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

}
