package Ejercicio3;

/**
 *
 * @author Bruno Tarditi
 */
public class Proveedor {
    
    //Atributos
    private int codigo;
    private String razonSocial;
    
    //Constructor vacío
    public Proveedor(){
        
    }

    //Constructor sobrecargado
    public Proveedor(int codigo, String razonSocial) {
        this.codigo = codigo;
        this.razonSocial = razonSocial;
        
    }

    //Get and Set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    
    
}
