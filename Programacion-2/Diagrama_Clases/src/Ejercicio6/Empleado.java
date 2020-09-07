package Ejercicio6;

import java.util.Date;

/**
 *
 * @author Bruno Tarditi
 */
public class Empleado extends Persona {

    private Date fecha_Ingreso;
    private int nro_Legajo;

    public Empleado() {

        this.fecha_Ingreso = null;
        this.nro_Legajo = 0;
    }

    public Empleado(Date fecha_Ingreso, int nro_Legajo, int dni, String nombre, String apellido, long cuit) {
        super(dni, nombre, apellido, cuit);
        this.fecha_Ingreso = fecha_Ingreso;
        this.nro_Legajo = nro_Legajo;
    }

    public Date getFecha_Ingreso() {
        return fecha_Ingreso;
    }

    public int getNro_Legajo() {
        return nro_Legajo;
    }

    public void setFecha_Ingreso(Date fecha_Ingreso) {
        this.fecha_Ingreso = fecha_Ingreso;
    }

    public void setNro_Legajo(int nro_Legajo) {
        this.nro_Legajo = nro_Legajo;
    }

    @Override
    public long getCuit() {
        return cuit;
    }

    @Override
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

}
