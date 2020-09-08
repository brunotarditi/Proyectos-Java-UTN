package EjercicioD;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Vivienda {

    //atributos
    private long id;
    private String calle;
    private int numeroCalle;
    private Double superficieTerreno;
    private Barrio barrio;
    private List<Habitacion> habitaciones = new ArrayList<>();

    //constructor vacío 
    public Vivienda() {
    }
    //constructor sobrecargado
    public Vivienda(long id, String calle, int numeroCalle, Double superficieTerreno, Barrio barrio) {
        this.id = id;
        this.calle = calle;
        this.numeroCalle = numeroCalle;
        this.superficieTerreno = superficieTerreno;
        this.barrio = barrio;
    }

    //get y set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public Double getSuperficieTerreno() {
        return superficieTerreno;
    }

    public void setSuperficieTerreno(Double superficieTerreno) {
        this.superficieTerreno = superficieTerreno;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

}
