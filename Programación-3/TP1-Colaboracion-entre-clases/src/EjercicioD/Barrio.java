package EjercicioD;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Barrio {

    //atributos
    private long id;
    private String nombre;
    private String empresaConstructora;
    private List<Vivienda> viviendas = new ArrayList<>();

    //constructor vacío
    public Barrio() {
    }

    //constructor sobrecargado
    public Barrio(long id, String nombre, String empresaConstructora) {
        this.id = id;
        this.nombre = nombre;
        this.empresaConstructora = empresaConstructora;
    }

    //get y set 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresaConstructora() {
        return empresaConstructora;
    }

    public void setEmpresaConstructora(String empresaConstructora) {
        this.empresaConstructora = empresaConstructora;
    }

    public List<Vivienda> getViviendas() {
        return viviendas;
    }

    public void setViviendas(List<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }

}
