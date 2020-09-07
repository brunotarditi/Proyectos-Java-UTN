package Ejercicio7;

import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Detective extends Persona {

    private String numeroPlaca;

    public Detective() {
        
    }

    public Detective(String numeroPlaca, String nombre, String apellido, Foto foto, List<Perfil> perfiles) {
        super(nombre, apellido, foto);
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public boolean investigarMafioso(Mafioso mafioso) {

        return mafioso.investigar();
    }
}
