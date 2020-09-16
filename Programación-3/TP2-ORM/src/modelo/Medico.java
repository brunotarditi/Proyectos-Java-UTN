package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Bruno Tarditi
 */
public class Medico extends Persona implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    //private int idMedico;
    private int matricula;
    private long celular;
    private List<Especialidad> especialidades = new ArrayList<>();
    private List<Turno> turnos = new ArrayList<>();

    public Medico() {
    }

    public Medico( int matricula, long celular, String nombre, String apellido, long dni, Domicilio domicilio) {
        super(nombre, apellido, dni, domicilio);
        this.matricula = matricula;
        this.celular = celular;
    }

//    public int getIdMedico() {
//        return idMedico;
//    }
//
//    public void setIdMedico(int idMedico) {
//        this.idMedico = idMedico;
//    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    @ManyToMany(targetEntity = Especialidad.class,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "MEDICO_ESPECIALIDAD",
            joinColumns = @JoinColumn(name = "ESPECIALIDAD_ID"),
            inverseJoinColumns = @JoinColumn(name = "MEDICO_ID")
    )
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDomicilio")
    @Override
    public Domicilio getDomicilio() {
        return this.domicilio;
    }

    @Override
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
