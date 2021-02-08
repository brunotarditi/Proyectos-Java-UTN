package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "tipo_articulo")
public class TipoArticulo implements Serializable {
    private static final long serialVersionUID = 1L;
    private long idTipoArticulo;
    private String denominacion;
    private List<Articulo> articulo;

    public TipoArticulo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(long idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "tiposDeArticulo",
    targetEntity = Articulo.class)
    public List<Articulo> getArticulo() {
        return articulo;
    }

    public void setArticulo(List<Articulo> articulo) {
        this.articulo = articulo;
    }
}
