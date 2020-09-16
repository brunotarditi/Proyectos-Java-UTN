package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Bruno Tarditi
 */
@Entity
public class Especialidad extends EntityBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int idEspecialidad;
    private String denominacion;
    private List<Medico> medicos = new ArrayList<>();

    public Especialidad() {
    }

    public Especialidad(int idEspecialidad, String denominacion) {
        this.idEspecialidad = idEspecialidad;
        this.denominacion = denominacion;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "especialidades",
            targetEntity = Medico.class
    )
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
