package EjercicioC;

import java.util.Date;

/**
 *
 * @author Bruno Tarditi
 */
public class Actividad {

    //atributos
    private Date fechaInicio;
    private Date fechaFin;
    private String nombre;
    private String descripcion;
    private TipoActividad tipoActividad;

    //constructor vacío
    public Actividad() {
    }

    //constructor sobrecargado
    public Actividad(Date fechaInicio, Date fechaFin, String nombre, String descripcion, TipoActividad tipoActividad) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoActividad = tipoActividad;
    }

    //get y set
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
