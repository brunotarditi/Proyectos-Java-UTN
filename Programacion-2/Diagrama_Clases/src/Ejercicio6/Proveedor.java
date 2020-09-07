package Ejercicio6;

/**
 *
 * @author Bruno Tarditi
 */
public class Proveedor extends Persona implements Estado_cuenta {

    private String nombre_Comercial;

    public Proveedor() {

        this.nombre_Comercial = "";
        
    }

    public Proveedor(String nombre_Comercial, int dni, String nombre, String apellido, long cuit) {
        super(dni, nombre, apellido, cuit);
        this.nombre_Comercial = nombre_Comercial;
    }

    public String getNombre_Comercial() {
        return nombre_Comercial;
    }

    public void setNombre_Comercial(String nombre_Comercial) {
        this.nombre_Comercial = nombre_Comercial;
    }

    @Override
    public boolean problemaVerazCodeme() {

        return false;
    }

    @Override
    public long getCuit() {
        return cuit;
    }

    @Override
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

}
