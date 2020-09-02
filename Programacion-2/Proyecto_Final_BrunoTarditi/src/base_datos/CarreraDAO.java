package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.CarreraModelo;

/**
 *
 * @author Bruno Tarditi
 */
public class CarreraDAO extends SQLQuery {

    private ArrayList<CarreraModelo> carreras;
    private CarreraModelo carrera;

    public ArrayList<CarreraModelo> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<CarreraModelo> carreras) {
        this.carreras = carreras;
    }

    public boolean cargarDatosDAO(CarreraModelo carrera) {

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO carrera (car_cod, car_nombre, car_duracion) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement(sql);
            preparedStmt.setLong(1, carrera.getCod_carrera());
            preparedStmt.setString(2, carrera.getNombre());
            preparedStmt.setLong(3, carrera.getDuracion());

            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public ArrayList<CarreraModelo> mostrarCarrerasDAO() {

        carreras = new ArrayList();

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from carrera");
            ResultSet hoja_de_resultado = consulta.executeQuery();
            while (hoja_de_resultado.next()) {
                carrera = new CarreraModelo();
                carrera.setCod_carrera(hoja_de_resultado.getLong(1));
                carrera.setNombre(hoja_de_resultado.getString(2));
                carrera.setDuracion(hoja_de_resultado.getLong(3));

                carreras.add(carrera);

            }

            this.desconectar();

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return carreras;
    }

    public boolean bajaDAO(JTable tabla) {
        int seleccion;
        carreras = new ArrayList(mostrarCarrerasDAO());
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("DELETE FROM carrera WHERE car_cod = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, carreras.get(seleccion).getCod_carrera());
            consulta.executeUpdate();

            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificaDAO(CarreraModelo carrera) {
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement("UPDATE carrera SET car_nombre=?, car_duracion=? WHERE car_cod=?");
           
            preparedStmt.setString(1, carrera.getNombre());
            preparedStmt.setLong(2, carrera.getDuracion());
             preparedStmt.setLong(3, carrera.getCod_carrera());

            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    //Metodo para que no se repita el nombre de la carrera
    public boolean carerraRepetidaDAO(CarreraModelo carrera){
       
       try {
           this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from carrera where car_nombre=?");
            this.consulta.setString(1, carrera.getNombre());
            ResultSet hojadeResultados = consulta.executeQuery();
            if(hojadeResultados.next()){
                return false;              
            }
            this.desconectar();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return true;
   }

}
