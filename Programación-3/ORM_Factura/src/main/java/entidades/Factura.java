package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFactura;

    private String fecha;
    private int numero;
    private double total;

    // relacion de una factura a muchos detalles de facturas.pk = factura
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturaDetalle> facturasDetalle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    public Factura() {
    }

    public Factura(long idFactura) {
        this.idFactura = idFactura;
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
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

    public List<FacturaDetalle> getFacturasDetalle() {
        return facturasDetalle;
    }

    public void setFacturasDetalle(List<FacturaDetalle> facturasDetalle) {
        this.facturasDetalle = facturasDetalle;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
