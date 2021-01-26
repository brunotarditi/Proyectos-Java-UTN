package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "factura")
public class Factura implements Serializable {
    private long idFactura;
    private String fecha;
    private int numero;
    private double total;
    private List<FacturaDetalle> facturasDetalle;
    private Proveedor proveedor;

    public Factura() {
    }

    @Id
    public long getId() {
        return idFactura;
    }

    public void setId(long idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    // relacion de una factura a muchos detalles de facturas.pk = factura
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    public List<FacturaDetalle> getFacturasDetalle() {
        return facturasDetalle;
    }

    public void setFacturasDetalle(List<FacturaDetalle> facturasDetalle) {
        this.facturasDetalle = facturasDetalle;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProveedor")
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
