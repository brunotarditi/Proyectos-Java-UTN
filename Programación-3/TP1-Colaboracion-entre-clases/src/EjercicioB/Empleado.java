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

    //---------------B2)
    /*Codifique en la clase public List<Asistencia> getAsistenciaXMesXAnio(int mes,
    int anio){} que retorne solo las asistencias del empleado correspondientes al mes y
    año indicados*/
    public List<Asistencia> getAsistenciaXMesXAnio(int mes, int anio) {

        List<Asistencia> asistenciaMesAnio = new ArrayList<>();

        if (getAsistencias() != null) {
            for (Asistencia asistencia : this.asistencias) {
                if (asistencia.getFecha().getMonth() == mes && asistencia.getFecha().getYear() + 1900 == anio) {
                    asistenciaMesAnio.add(asistencia);
                }
            }

        }
        return asistenciaMesAnio;
    }

    //---------------B3)
    /*Codifique en la clase public List<Tardanza> getDiasConTardanza(int mes, int
    anio){} retorne los días con tardanza para hacerlo verifique el horario de la asistencia
    contra el horario asignado en el régimen horario, si la asistencia supera en 15
    minutos el horario establecido en el régimen instancia de Tardanza y copie la
    información de la Asistencia a la Tardanza, almacene la tardanza en un Array del
    mismo tipo, finalmente retorne el Array de tardanzas. Reutilice el método punto
    anterior.*/
    public List<Tardanza> getDiasConTardanza(int mes, int anio) {

        List<Asistencia> asistenciaMesAnio = getAsistenciaXMesXAnio(mes, anio);
        List<Tardanza> tardanzaMesAnio = new ArrayList<>();

        if (getAsistencias() != null) {
            for (Asistencia asistencia : this.asistencias) {
                if (asistencia.getMinuto() > this.regimenHorario.getMinutoIngreso() + 15 && asistencia.getHora() >= this.regimenHorario.getHoraIngreso()) {

                    Tardanza tardanza = new Tardanza();
                    tardanza.setId(asistencia.getId());
                    tardanza.setTipo(asistencia.getTipo());
                    tardanza.setFecha(asistencia.getFecha());
                    tardanza.setHora(asistencia.getHora());
                    tardanza.setMinuto(asistencia.getMinuto());
                    tardanzaMesAnio.add(tardanza);

                }

            }
        }

        return tardanzaMesAnio;

    }

}
