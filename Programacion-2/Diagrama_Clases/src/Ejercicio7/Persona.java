package Ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Persona {

    private String nombre;
    private String apellido;
    private Foto foto;
    private ArrayList<MedioDeComuniacion> comunicaciones = new ArrayList<>();
    private List<Perfil> perfiles = new ArrayList<>();

    public Persona() {

    }

    public Persona(String nombre, String apellido, Foto foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        

    }

    public void agregarPerfil(Perfil perfil) {
        this.perfiles.add(perfil);
    }

    public void quitarPerfil(Perfil perfil) {
        this.perfiles.remove(perfil);
    }

    public ArrayList<MedioDeComuniacion> getComunicaciones() {
        return comunicaciones;
    }

    public void setComunicaciones(ArrayList<MedioDeComuniacion> comunicaciones) {
        this.comunicaciones = comunicaciones;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
    
    
}
