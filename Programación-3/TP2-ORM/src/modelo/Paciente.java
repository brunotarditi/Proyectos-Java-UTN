package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Bruno Tarditi
 */
public class Paciente extends Persona implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int idPaciente;
    private int nroSocio;
    private HistoriaClinica historiaClinica;
    private List<Turno> turnos = new ArrayList<>();

    public Paciente() {
    }

    public Paciente(int idPaciente, int nroSocio, HistoriaClinica historiaClinica, int idPersona, String nombre, String apellido, long dni, Domicilio domicilio) {
        super(idPersona, nombre, apellido, dni, domicilio);
        this.idPaciente = idPaciente;
        this.nroSocio = nroSocio;
        this.historiaClinica = historiaClinica;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }
    @OneToOne(cascade = {CascadeType.ALL}) 
    @JoinColumn(name = "idHistoriaClinica")
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
