package modelo;

import base_datos.CarreraDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Bruno Tarditi
 */
public class CarreraModelo {

    private long cod_carrera;
    private String nombre;
    private long duracion;
    private CarreraDAO carreraDAO = new CarreraDAO();

    public long getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(long cod_carrera) {
        this.cod_carrera = cod_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;

    }

    public boolean validaCarga(String a) {
        if (a.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean carreraRepetida(CarreraModelo carrera) {
        return carreraDAO.carerraRepetidaDAO(carrera);
    }

    public boolean cargaDatos(CarreraModelo carrera) {

        return carreraDAO.cargarDatosDAO(carrera);

    }

    public ArrayList<CarreraModelo> muestraDatos() {
        return carreraDAO.mostrarCarrerasDAO();
    }

    public boolean modificaDatos(CarreraModelo carrera) {
        return carreraDAO.modificaDAO(carrera);
    }

    public boolean bajaDatos(JTable tabla) {

        return carreraDAO.bajaDAO(tabla);
    }

}
