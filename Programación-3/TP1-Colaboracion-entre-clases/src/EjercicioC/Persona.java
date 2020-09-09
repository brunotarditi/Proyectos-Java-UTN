package EjercicioC;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Persona {

    //atributos
    private String nombre;
    private String tipoDocumento;
    private long nroDocumento;
    private int telefono;
    private String email;
    private String celular;
    private Sector sector;
    private List<Actividad> actividades = new ArrayList<>();

    //constructor vacío
    public Persona() {
    }

    //constructor sobrecargado
    public Persona(String nombre, String tipoDocumento, long nroDocumento, int telefono, String email, String celular, Sector sector) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.telefono = telefono;
        this.email = email;
        this.celular = celular;
        this.sector = sector;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(long nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    //---------------C1)
    /*C.1- Codifique en la clase Persona un método denominado “public doublé
    totalPuntosAsignados()” que retorne el total de puntos asignados de las actividades
    realizadas por una persona.*/
    public double totalPuntosAsignados() {

        double totalPuntos = 0.0;

        if (getActividades() != null) {
            for (Actividad actividad : this.actividades) {
                totalPuntos += actividad.getTipoActividad().getPuntosAsignados();
            }
        }
        return totalPuntos;
    }

    //---------------C2)
    /*C.2- Codifique en la clase Persona un método denominado “public doublé
    totalPuntosAsignados (int código)” que retorne el total de puntos asignados de un
    único tipo de actividad realizada por una persona.*/
    public double totalPuntosAsignados(int codigo) {

        double totalPuntos = 0.0;
        if (getActividades() != null) {
            for (Actividad actividad : this.actividades) {
                if (actividad.getTipoActividad().getCodigo() == codigo) {
                    totalPuntos += actividad.getTipoActividad().getPuntosAsignados();
                }
            }
        }
        return totalPuntos;
    }

    //---------------C3)
    /*C.3- Codifique en la clase Persona un método denominado “public doublé
    totalPuntosAsignados (int código, int anio)” que retorne el total de puntos
    asignados de un único tipo de actividad realizada por una persona para un periodo
    asignado.*/
    
    public double totalPuntosAsignados(int codigo, int anio){
        double totalPuntos =  0.0;
        if (getActividades() != null) {
            for (Actividad actividad : this.actividades) {
                if (actividad.getTipoActividad().getCodigo() == codigo && actividad.getFechaInicio().getYear() + 1900 <= anio 
                        && actividad.getFechaFin().getYear() + 1900 >= anio) {
                    totalPuntos  += actividad.getTipoActividad().getPuntosAsignados();
                }
            }
        }
        return totalPuntos;
    }
      
}
