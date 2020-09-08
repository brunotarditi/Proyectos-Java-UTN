package EjercicioA;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Expediente {

    //atributos
    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String ambito;
    private String tipo;
    private Expediente expedientePadre;
    private List<Expediente> expedientesHijos = new ArrayList<>();
    private List<Control> controles = new ArrayList<>();

    //constructor vacío
    public Expediente() {
    }

    //constructor sobrecargado
    public Expediente(int id, String letra, int numero, String descripcion, String ambito, String tipo, Expediente expedientePadre) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.descripcion = descripcion;
        this.ambito = ambito;
        this.tipo = tipo;
        this.expedientePadre = expedientePadre;
    }

    //get y set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Expediente getExpedientePadre() {
        return expedientePadre;
    }

    public void setExpedientePadre(Expediente expedientePadre) {
        this.expedientePadre = expedientePadre;
    }

    public List<Expediente> getExpedientesHijos() {
        return expedientesHijos;
    }

    public void setExpedientesHijos(List<Expediente> expedientesHijos) {
        this.expedientesHijos = expedientesHijos;
    }

    public List<Control> getControles() {
        return controles;
    }

    public void setControles(List<Control> controles) {
        this.controles = controles;
    }

    //---------------A1)
    /*A.1- Codifique en la clase Expediente un método denominado “public String getCaratulaExpediente()” 
    que retorne la concatenación de los campos número, letra y descripción separados con guion medio -*/
    public String getCaratulaExpediente() {

        return this.numero + "-" + this.letra + "-" + this.descripcion;
    }

    //---------------A2)
    /*A.2- Codifique en la clase Expediente un método denominado “public String getControlesObligatorios ()” 
    que retorne una lista separada con comas de la denominación de los controles obligatorios asociados al expedientes.*/
    public String getControlesObligatorio() {

        String cadenaControl = "";
        if (this.getControles() != null) {
            for (Control control : this.controles) {
                if (control.isEsObligatorio()) {
                    cadenaControl += control.getDenominacion() + ", ";
                }
            }
        }
        return cadenaControl;
    }

    //---------------A3)
    /*A.3- Codifique en la clase Expediente un método denominado “public boolean getEstadoControles()” 
    que retorne true en caso de que todos los estados de los controles obligatorios se encuentren aprobados, 
    caso contrario retorne false.*/
    public boolean getEstadoControles() {

        if (this.getControles() != null) {
            for (Control control : this.controles) {
                if (control.isEsObligatorio()) {
                    if (!control.getEstadoControl().isAprobado()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //---------------A4)
    /*A.4- Codifique en la clase Expediente un método denominado “public List<Expediente> listaExpedientes()” 
    que haciendo uso de RECURSIÓN retorne una lista de objetos Expediente asociados a él. 
    (Nota: para resolver el ejercicio es recomendable usar un método auxiliar que realice la recursión)*/
    public List<Expediente> listaExpedientes() {
        List<Expediente> listaRecursion = new ArrayList<Expediente>();
        listaExpedientesRecursiva(this, listaRecursion);
        return listaRecursion;

    }

    public void listaExpedientesRecursiva(Expediente exp, List<Expediente> lista) {

        lista.add(exp);
        if (exp.getExpedientesHijos() != null) {
            for (Expediente expHijos : exp.getExpedientesHijos()) {
                listaExpedientesRecursiva(expHijos, lista);
            }
        }
    }

}
