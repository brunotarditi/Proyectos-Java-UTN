package Ejercicio6;

import java.util.Date;

/**
 *
 * @author Bruno Tarditi
 */
public class Tarjeta_de_Credito {

    private Date fecha_Ingreso;
    private double limite;

    public Tarjeta_de_Credito() {

        this.fecha_Ingreso = null;
        this.limite = 0.0;
    }

    public Tarjeta_de_Credito(Date fecha_Ingreso, double limite) {
        this.fecha_Ingreso = fecha_Ingreso;
        this.limite = limite;
    }

    public Date getFecha_Ingreso() {
        return fecha_Ingreso;
    }

    public double getLimite() {
        return limite;
    }

    public void setFecha_Ingreso(Date fecha_Ingreso) {
        this.fecha_Ingreso = fecha_Ingreso;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

}
