package modelo;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bruno Tarditi
 */
public class DetalleHistoriaClinica extends EntityBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private int idDetalleHC;
    private Date fechaAtencion;
    private String sintomas;
    private String diagnostico;
    private String observaciones;
    private HistoriaClinica historiaClinica;

    public DetalleHistoriaClinica() {
    }

    public DetalleHistoriaClinica(int idDetalleHC, Date fechaAtencion, String sintomas, String diagnostico, String observaciones, HistoriaClinica historiaClinica) {
        this.idDetalleHC = idDetalleHC;
        this.fechaAtencion = fechaAtencion;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.historiaClinica = historiaClinica;
    }

    public int getIdDetalleHC() {
        return idDetalleHC;
    }

    public void setIdDetalleHC(int idDetalleHC) {
        this.idDetalleHC = idDetalleHC;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHistoriaClinica")
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
