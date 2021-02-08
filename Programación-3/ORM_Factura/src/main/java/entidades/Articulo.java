package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idArticulo;
    private String denominacion;
    private int cantidad;
    private List<FacturaDetalle> facturasDetalle;
    private List<TipoArticulo> tiposDeArticulo;

    public Articulo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    // Relacion un articulo muchos detalles de facturas.pk = articulo
    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    public List<FacturaDetalle> getFacturasDetalle() {
        return facturasDetalle;
    }

    public void setFacturasDetalle(List<FacturaDetalle> facturasDetalle) {
        this.facturasDetalle = facturasDetalle;
    }

    @ManyToMany(fetch = FetchType.LAZY,
    targetEntity = TipoArticulo.class,
    cascade = CascadeType.ALL)
    @JoinTable(name = "ARTICULO_TIPO_ARTICULO",
    joinColumns = @JoinColumn(name = "ARTICULO_ID"),
    inverseJoinColumns = @JoinColumn(name = "TIPO_ARTICULO_ID"))
    public List<TipoArticulo> getTiposDeArticulo() {
        return tiposDeArticulo;
    }

    public void setTiposDeArticulo(List<TipoArticulo> tiposDeArticulo) {
        this.tiposDeArticulo = tiposDeArticulo;
    }
}
