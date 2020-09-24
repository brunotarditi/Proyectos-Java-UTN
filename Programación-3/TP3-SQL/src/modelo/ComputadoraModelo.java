package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class ComputadoraModelo extends EntityApp {

    private String codigo;
    private String marca;
    private String modelo;
    private List<ComponenteModelo> componentes = new ArrayList<>();

    public ComputadoraModelo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<ComponenteModelo> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<ComponenteModelo> componentes) {
        this.componentes = componentes;
    }

}
