package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "proveedor")
public class Proveedor implements Serializable {
    private long idProveedor;
    private String cuit;
    private String razonSocial;
    private Domicilio domicilio;
    private List<Factura> facturas;

    public Proveedor() {
    }

    @Id
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
    // relacion de un proveedor con un domicilio.pk = idDomicilio
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idDomicilio")
    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    //asociacion de un proveedor a muchas facturas.pk = proveedor
    @OneToMany (mappedBy = "proveedor", cascade = CascadeType.ALL)
    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
