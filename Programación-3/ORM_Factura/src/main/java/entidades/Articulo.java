package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArticulo;

    private String denominacion;
    private int cantidad;

    // Relacion un articulo muchos detalles de facturas.pk = articulo
    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    private List<FacturaDetalle> facturasDetalle;

    @ManyToMany(fetch = FetchType.LAZY,
                targetEntity = TipoArticulo.class,
                cascade = CascadeType.ALL)
    @JoinTable(name = "ARTICULO_TIPO_ARTICULO",
                joinColumns = @JoinColumn(name = "ARTICULO_ID"),
                inverseJoinColumns = @JoinColumn(name = "TIPO_ARTICULO_ID"))
    private List<TipoArticulo> tiposDeArticulo;

    public Articulo() {
    }

    public Articulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public long getIdArticulo() {
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

    public List<FacturaDetalle> getFacturasDetalle() {
        return facturasDetalle;
    }

    public void setFacturasDetalle(List<FacturaDetalle> facturasDetalle) {
        this.facturasDetalle = facturasDetalle;
    }

    public List<TipoArticulo> getTiposDeArticulo() {
        return tiposDeArticulo;
    }

    public void setTiposDeArticulo(List<TipoArticulo> tiposDeArticulo) {
        this.tiposDeArticulo = tiposDeArticulo;
    }

}
