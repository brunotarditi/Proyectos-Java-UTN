package Ejercicio6;

import java.util.Date;

/**
 *
 * @author Bruno Tarditi
 */
public class Factura {

    private Empleado emp = new Empleado();
    private Cliente clie = new Cliente();
    private int num_Factura;
    private Date fecha;
    private double monto;

    public Factura() {

        this.fecha = null;
        this.monto = 0.0;
        this.num_Factura = 0;
        
        
    }

    public Factura(int num_Factura, Date fecha, double monto) {
        this.num_Factura = num_Factura;
        this.fecha = fecha;
        this.monto = monto;
        
    }

    public Empleado getEmp() {
        return emp;
    }

    public Cliente getClie() {
        return clie;
    }

    public int getNum_Factura() {
        return num_Factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public void setClie(Cliente clie) {
        this.clie = clie;
    }

    public void setNum_Factura(int num_Factura) {
        this.num_Factura = num_Factura;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
