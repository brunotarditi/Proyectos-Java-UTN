package EjercicioC;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Sector {

    //atributos
    private int numero;
    private String denominacion;
    private String tipo;
    private Sector sectorPadre;
    private List<Sector> sectoresHijos = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();
    
    //constructor vacío
    public Sector() {
    }
    
    //constructor sobrecargado
    public Sector(int numero, String denominacion, String tipo, Sector sectorPadre) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.tipo = tipo;
        this.sectorPadre = sectorPadre;
    }

    //get y set
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Sector getSectorPadre() {
        return sectorPadre;
    }

    public void setSectorPadre(Sector sectorPadre) {
        this.sectorPadre = sectorPadre;
    }

    public List<Sector> getSectoresHijos() {
        return sectoresHijos;
    }

    public void setSectoresHijos(List<Sector> sectoresHijos) {
        this.sectoresHijos = sectoresHijos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
      
    //---------------C4)
    /*C.4- Codifique en la clase Sector un método RECURSIVO denominado “public
    List<Sector> obtenerTotalSubsectores()” que retorne la totalidad de subsectores de
    un sector.*/
    public List<Sector> obtenerTotalSubsectores() {
        List<Sector> listaRecursion = new ArrayList<Sector>();
        listaSectoresRecursiva(this, listaRecursion);
        return listaRecursion;

    }

    //metodo auxiliar
    public void listaSectoresRecursiva(Sector sec, List<Sector> lista) {

        lista.add(sec);
        if (sec.getSectoresHijos()!= null) {
            for (Sector secHijos : sec.getSectoresHijos()) {
                listaSectoresRecursiva(secHijos, lista);
            }
        }
    }

}
