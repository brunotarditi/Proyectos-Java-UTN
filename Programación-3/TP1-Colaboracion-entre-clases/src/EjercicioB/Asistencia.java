package EjercicioB;

import java.util.Date;

/**
 *
 * @author Bruno Tarditi
 */
public class Asistencia {
    
    //atributos
    private long id;
    private String tipo;
    private Date fecha;
    private int hora;
    private int minuto;
    private Empleado empleado;
    
    //constructor vacío

    public Asistencia() {
    }

    //constructor sobrecargado
    public Asistencia(long id, String tipo, Date fecha, int hora, int minuto, Empleado empleado) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
        this.empleado = empleado;
    }
    
    //get y set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
