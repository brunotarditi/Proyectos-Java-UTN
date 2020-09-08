package EjercicioA;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class EstadoControl {

    private long id;
    private boolean aprobado;
    private List<Control> controles = new ArrayList<>();;

    public EstadoControl() {
    }

    public EstadoControl(long id, boolean aprobado, List<Control> controles) {
        this.id = id;
        this.aprobado = aprobado;
        this.controles = controles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public List<Control> getControles() {
        return controles;
    }

    public void setControles(List<Control> controles) {
        this.controles = controles;
    }

}
