package entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "detalle_de_factura")
public class FacturaDetalle implements Serializable {
    private long idFacturaDetalle;
    private int cantidad;
    private double subTotal;
    private Factura factura;
    private Articulo articulo;

    public FacturaDetalle() {
    }
    @Id
    public long getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(long idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    // relacion de muchos detalles de facturas a una factura.fk = idFactura
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "idFactura")
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    //relacion de muchos detalles de facturas a un articulo.fk = idArticulo
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "idArticulo")
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
