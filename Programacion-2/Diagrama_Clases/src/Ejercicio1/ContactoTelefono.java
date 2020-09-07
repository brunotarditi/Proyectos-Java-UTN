package Ejercicio1;

/**
 *
 * @author Bruno Tarditi
 */
public class ContactoTelefono {

    //atributos
    private Integer idContactoTelefono;
    private String codigo;
    private String numero;

    //Constructor vacío
    public ContactoTelefono() {

    }

    //Constructor sobrecargado
    public ContactoTelefono(Integer idContactoTelefono, String codigo, String numero) {
        this.idContactoTelefono = idContactoTelefono;
        this.codigo = codigo;
        this.numero = numero;
    }

    //Get and Set
    public Integer getIdContactoTelefono() {
        return idContactoTelefono;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

}
