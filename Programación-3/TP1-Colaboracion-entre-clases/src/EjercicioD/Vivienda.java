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

    //---------------D2)
    /*D.2- Codifique en la clase Vivienda un método denominado public double
    getMetrosCuadradosCubiertos(){} que retorne el total de metros cuadrados de la
    vivienda teniendo en cuenta la cantidad de habitaciones asociadas. Al finalizar el
    cálculo valide que el valor obtenido no sea mayor que la superficie del terreno, si
    ocurre esa situación emita una excepción con el mensaje “La superficie cubierta no
    puede ser mayor a la superficie del terreno”*/
    public double getMetrosCuadradosCubiertos() throws Exception {

        double totalMetrosHabitaciones = 0.0;
        if (getHabitaciones() != null) {
            for (Habitacion habitacion : this.habitaciones) {
                totalMetrosHabitaciones += habitacion.getMetrosCuadrados();
            }
        }
        if (totalMetrosHabitaciones > this.superficieTerreno) {
            throw new Exception("La superficie cubierta no puede ser mayor a la superficie del terreno");
        }

        return totalMetrosHabitaciones;

    }

}
