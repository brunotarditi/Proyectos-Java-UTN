package Ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author Bruno Tarditi
 */
public class Contacto extends Persona {

    //atributos
    private Integer idContacto;
    private ContactoTipo tipo;
    //Debe inicializar el ArraList por más que sea una agregación
    private ArrayList<ContactoDomicilio> domicilios = new ArrayList<>();
    private ArrayList<ContactoTelefono> telefonos = new ArrayList<>();

    //Constructor vacío
    public Contacto() {

    }

    //Constructor sobrecargado
    public Contacto(Integer idContacto, ContactoTipo tipo, String nombre, String apellido, int idPersona) {
        super(nombre, apellido, idPersona);
        this.idContacto = idContacto;
        this.tipo = tipo;
    }

    //Get and Set
    public Integer getIdContacto() {
        return idContacto;
    }

    public void setTipo(ContactoTipo tipo) {
        this.tipo = tipo;
    }

    public ContactoTipo getTipo() {
        return tipo;
    }

    public void addDomicilio(ContactoDomicilio domicilio) {
        this.domicilios.add(domicilio);
    }

    public ArrayList<ContactoDomicilio> getDomicilios() {
        return domicilios;
    }

    public void addTelefono(ContactoTelefono telefono) {
        this.telefonos.add(telefono);
    }

    public ArrayList<ContactoTelefono> getTelefonos() {
        return telefonos;
    }

}
