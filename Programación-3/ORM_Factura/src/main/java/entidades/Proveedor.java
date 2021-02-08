package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProveedor;

    private String cuit;
    private String razonSocial;

    // relacion de un proveedor con un domicilio.pk = idDomicilio
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idDomicilio")
    private Domicilio domicilio;

    //asociacion de un proveedor a muchas facturas.pk = proveedor
    @OneToMany (mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Proveedor() {
    }

    public Proveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

}
