package EjercicioB;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Empleado {

    //atributos
    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;
    private RegimenHorario regimenHorario;
    private List<Asistencia> asistencias = new ArrayList<>();
    private List<Tardanza> tardanzas = new ArrayList<>();

    //constructor vacío
    public Empleado() {
    }

    //constructor sobrecargado
    public Empleado(String nombre, long cuit, String domicilio, String email, RegimenHorario regimenHorario) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.email = email;
        this.regimenHorario = regimenHorario;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegimenHorario getRegimenHorario() {
        return regimenHorario;
    }

    public void setRegimenHorario(RegimenHorario regimenHorario) {
        this.regimenHorario = regimenHorario;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public List<Tardanza> getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(List<Tardanza> tardanzas) {
        this.tardanzas = tardanzas;
    }

}
