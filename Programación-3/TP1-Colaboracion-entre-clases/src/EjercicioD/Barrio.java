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

    //---------------D1)
    /*D.1- Codifique en la clase Barrio un método llamado public doublé
    getSuperficieTotalTerreno(){} que retorne el total de metros de terreno del barrio
    teniendo en cuenta la totalidad de viviendas asociadas al mismo.*/
    public double getSuperficieTotalTerreno() {

        double totalMtsTerrenos = 0.0;
        if (getViviendas() != null) {
            for (Vivienda vivienda : this.viviendas) {
                totalMtsTerrenos += vivienda.getSuperficieTerreno();
            }
        }
        return totalMtsTerrenos;
    }

    //---------------D3)
    /*D.3- Codifique en la clase Barrio un método llamado public doublé
    getSuperficieTotalCubierta(){} que retorne los metros cuadrados cubiertos del barrio
    sumando la totalidad de metros cuadrados cubiertos de las viviendas que componen
    al barrio. Reutilice el método getMetrosCuadradosCubiertos () del punto anterior.*/
    public double getSuperficieTotalCubierta() throws Exception {
        
        double totalMtsViviendas = 0.0;
        if (getViviendas() != null) {
            for (Vivienda vivienda : viviendas) {
                totalMtsViviendas += vivienda.getMetrosCuadradosCubiertos();
            }
        }
        return totalMtsViviendas;
    }

}
