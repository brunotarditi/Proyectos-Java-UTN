package Ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Mafioso extends Persona implements Investigable {

    private List<Lugar> lugaresFrecuentes = new ArrayList<Lugar>();

    public Mafioso() {
    }

    public Mafioso(String nombre, String apellido, Foto foto, List<Perfil> perfiles) {
        super(nombre, apellido, foto);
    }

    public void agregarLugar(Lugar lugar) {
        lugaresFrecuentes.add(lugar);
    }

    public List<Lugar> getLugaresFrecuentes() {
        return lugaresFrecuentes;
    }

    public void setLugaresFrecuentes(List<Lugar> lugaresFrecuentes) {
        this.lugaresFrecuentes = lugaresFrecuentes;
    }

    public boolean quitarLugar(Lugar lugar) {
        return lugaresFrecuentes.remove(lugar);
    }

    @Override
    public boolean investigar() {

        return false;

    }
}
