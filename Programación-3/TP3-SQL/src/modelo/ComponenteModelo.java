package modelo;

/**
 *
 * @author Bruno Tarditi
 */
public class ComponenteModelo extends EntityApp {

    private String nombre;
    private String nroSerie;
    private int idComputadora;
    private ComputadoraModelo computadora;

    public ComponenteModelo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public ComputadoraModelo getComputadora() {
        return computadora;
    }

    public void setComputadora(ComputadoraModelo computadora) {
        this.computadora = computadora;
    }

}
