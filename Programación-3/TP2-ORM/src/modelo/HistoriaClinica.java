package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Bruno Tarditi
 */
@Entity
public class HistoriaClinica extends EntityBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    //private int idHistoriaClinica;
    private int numero;
    private Date fechaAlta;
    private Paciente paciente;
    private List<DetalleHistoriaClinica> detalles = new ArrayList<>();

    public HistoriaClinica() {
    }

    public HistoriaClinica(int numero, Date fechaAlta, Paciente paciente) {
        this.numero = numero;
        this.fechaAlta = fechaAlta;
        this.paciente = paciente;
    }

//    public int getIdHistoriaClinica() {
//        return idHistoriaClinica;
//    }
//    public void setIdHistoriaClinica(int idHistoriaClinica) {
//        this.idHistoriaClinica = idHistoriaClinica;
//    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "historiaClinica")
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    public List<DetalleHistoriaClinica> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleHistoriaClinica> detalles) {
        this.detalles = detalles;
    }

    public void addDetallesHistoriaClinica(DetalleHistoriaClinica detalle) {
        this.detalles.add(detalle);
    }

}
