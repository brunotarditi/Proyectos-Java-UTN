package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.InscripcionModelo;

/**
 *
 * @author Bruno Tarditi
 */
public class InscripcionDAO extends SQLQuery {

    private ArrayList<InscripcionModelo> inscripciones;
    private InscripcionModelo inscripcion;

    public ArrayList<InscripcionModelo> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<InscripcionModelo> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public boolean cargarDatosDAO(InscripcionModelo inscripcion) {

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO inscripcion (insc_cod, insc_nombre, insc_fecha, insc_car_cod) VALUES (?,?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement(sql);
            preparedStmt.setLong(1, inscripcion.getInsc_cod());
            preparedStmt.setString(2, inscripcion.getInsc_nombre());
            preparedStmt.setDate(3, inscripcion.getInsc_fecha());
            preparedStmt.setLong(4, inscripcion.getInsc_car_cod());
            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<InscripcionModelo> mostrarInscripcionesDAO() {

        inscripciones = new ArrayList();

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from inscripcion");
            ResultSet hoja_de_resultado = consulta.executeQuery();
            while (hoja_de_resultado.next()) {
                inscripcion = new InscripcionModelo();
                inscripcion.setInsc_cod(hoja_de_resultado.getLong(1));
                inscripcion.setInsc_nombre(hoja_de_resultado.getString(2));
                inscripcion.setInsc_fecha(hoja_de_resultado.getDate(3));
                inscripcion.setInsc_car_cod(hoja_de_resultado.getLong(4));

                inscripciones.add(inscripcion);

            }

            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return inscripciones;
    }

    public boolean bajaDAO(JTable tabla) {
        int seleccion;
        inscripciones = new ArrayList(mostrarInscripcionesDAO());
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("DELETE FROM inscripcion WHERE insc_cod = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, inscripciones.get(seleccion).getInsc_cod());
            consulta.executeUpdate();

            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificaDAO(InscripcionModelo inscripcion) {
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement("UPDATE inscripcion SET insc_nombre=?, insc_fecha=?, insc_car_cod=? WHERE insc_cod=?");

            preparedStmt.setString(1, inscripcion.getInsc_nombre());
            preparedStmt.setDate(2, inscripcion.getInsc_fecha());
            preparedStmt.setLong(3, inscripcion.getInsc_car_cod());
            preparedStmt.setLong(4, inscripcion.getInsc_cod());

            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<String> RetornaInscCarCodDAO() {
        ArrayList<String> insc_car_cod = new ArrayList<>();
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select car_cod from carrera");
            ResultSet hoja_de_resultado = consulta.executeQuery();
            insc_car_cod.add("");
            while (hoja_de_resultado.next()) {
                insc_car_cod.add(Long.toString(hoja_de_resultado.getLong(1)));
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insc_car_cod;
    }

}
