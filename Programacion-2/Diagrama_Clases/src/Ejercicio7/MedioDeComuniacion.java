package Ejercicio7;

/**
 *
 * @author Bruno Tarditi
 */
public class MedioDeComuniacion {

    private String descripcion;
    private TipoMedio tipomedio;

    public MedioDeComuniacion() {
        this.descripcion = "";

    }

    public MedioDeComuniacion(String descripcion, TipoMedio tipomedio) {
        this.descripcion = descripcion;
        this.tipomedio = tipomedio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoMedio getTipomedio() {
        return tipomedio;
    }

    public void setTipomedio(TipoMedio tipomedio) {
        this.tipomedio = tipomedio;
    }

}
