package Ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author Bruno Tarditi
 */
public class Usuario extends Persona {

    //atributos
    private Integer idUsuario;
    private String usuario;
    private String password;
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    //Constructor vacío
    public Usuario() {

    }

    //Constructor sobrecargado
    public Usuario(Integer idUsuario, String usuario, String password, String nombre, String apellido, int idPersona) {
        super(nombre, apellido, idPersona);
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    //Get and Set
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void addContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

}
