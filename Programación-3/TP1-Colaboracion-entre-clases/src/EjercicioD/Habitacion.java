package EjercicioD;

/**
 *
 * @author Bruno Tarditi
 */
public class Habitacion {

    //atributos
    private long id;
    private String nombre;
    private long metrosCuadrados;
    private Vivienda vivienda;

    //constructor vacío
    public Habitacion() {
    }

    //constructor sobrecargado
    public Habitacion(long id, String nombre, long metrosCuadrados, Vivienda vivienda) {
        this.id = id;
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
        this.vivienda = vivienda;
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

    public long getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(long metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

}
