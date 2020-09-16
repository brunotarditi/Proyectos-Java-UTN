package modelo;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bruno Tarditi
 */
@Entity
public class Turno extends EntityBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int idTurno;
    private Date fecha;
    private int hora;
    private int minutos;
    private Paciente paciente;
    private Medico medico;

    public Turno() {
    }

    public Turno(int idTurno, Date fecha, int hora, int minutos, Paciente paciente, Medico medico) {
        this.idTurno = idTurno;
        this.fecha = fecha;
        this.hora = hora;
        this.minutos = minutos;
        this.paciente = paciente;
        this.medico = medico;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
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

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaciente")
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMedico")
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
