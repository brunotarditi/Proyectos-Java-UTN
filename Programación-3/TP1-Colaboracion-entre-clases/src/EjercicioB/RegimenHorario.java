package EjercicioB;

/**
 *
 * @author Bruno Tarditi
 */
public class RegimenHorario {
    
    //atributos
    private long id;
    private int horaIngreso;
    private int minutoIngreso;
    private int horaEgreso;
    private int minutoEgreso;
    private Empleado empleado;
    
    //contructor vacío

    public RegimenHorario() {
    }
    
    //constructor sobrecargado

    public RegimenHorario(long id, int horaIngreso, int horaEgreso,int minutoIngreso, int minutoEgreso, Empleado empleado) {
        this.id = id;
        this.horaIngreso = horaIngreso;
        this.minutoIngreso = minutoEgreso;
        this.horaEgreso = horaEgreso;
        this.minutoEgreso = minutoEgreso;
        this.empleado = empleado;
    }
    
    //get y set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getMinutoIngreso() {
        return minutoIngreso;
    }

    public void setMinutoIngreso(int minutoIngreso) {
        this.minutoIngreso = minutoIngreso;
    }
    
    

    public int getHoraEgreso() {
        return horaEgreso;
    }

    public void setHoraEgreso(int horaEgreso) {
        this.horaEgreso = horaEgreso;
    }

    public int getMinutoEgreso() {
        return minutoEgreso;
    }

    public void setMinutoEgreso(int minutoEgreso) {
        this.minutoEgreso = minutoEgreso;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
}
