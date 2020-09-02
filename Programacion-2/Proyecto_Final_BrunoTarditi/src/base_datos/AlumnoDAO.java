package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.AlumnoModelo;

/**
 *
 * @author Bruno Tarditi
 */
public class AlumnoDAO extends SQLQuery {

    private ArrayList<AlumnoModelo> alumnos;
    private AlumnoModelo alumno;

    public ArrayList<AlumnoModelo> getAlumnos() {

        return alumnos;
    }

    public void setAlumnos(ArrayList<AlumnoModelo> alumnos) {
        this.alumnos = alumnos;
    }

    public boolean cargarDatosDAO(AlumnoModelo alumno) {

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO alumno (alu_dni, alu_nombre, alu_apellido, alu_fec_nac, alu_domicilio, alu_telefono, alu_insc_cod) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement(sql);
            preparedStmt.setLong(1, alumno.getDni());
            preparedStmt.setString(2, alumno.getNombre());
            preparedStmt.setString(3, alumno.getApellido());
            preparedStmt.setDate(4, alumno.getFecha());
            preparedStmt.setString(5, alumno.getDomicilio());
            preparedStmt.setString(6, alumno.getTelefono());
            preparedStmt.setLong(7, alumno.getInsc_cod());
            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public ArrayList<AlumnoModelo> mostrarAlumnosDAO() {

        alumnos = new ArrayList();

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from alumno");
            ResultSet hoja_de_resultado = consulta.executeQuery();
            while (hoja_de_resultado.next()) {
                alumno = new AlumnoModelo();
                alumno.setDni(hoja_de_resultado.getLong(1));
                alumno.setNombre(hoja_de_resultado.getString(2));
                alumno.setApellido(hoja_de_resultado.getString(3));
                alumno.setFecha(hoja_de_resultado.getDate(4));
                alumno.setDomicilio(hoja_de_resultado.getString(5));
                alumno.setTelefono(hoja_de_resultado.getString(6));
                alumno.setInsc_cod(hoja_de_resultado.getLong(7));
                alumnos.add(alumno); 
                
            }
            
            this.desconectar();

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return alumnos;
    }
    
    
    public boolean modificaDAO(AlumnoModelo alumno) {    
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement("UPDATE alumno SET alu_nombre=?, alu_apellido=?, alu_fec_nac=?, alu_domicilio=?, alu_telefono=?, alu_insc_cod=? WHERE alu_dni=?");
            preparedStmt.setString(1, alumno.getNombre());
            preparedStmt.setString(2, alumno.getApellido());
            preparedStmt.setDate(3, alumno.getFecha());
            preparedStmt.setString(4, alumno.getTelefono());
            preparedStmt.setString(5, alumno.getDomicilio());
            preparedStmt.setLong(6, alumno.getInsc_cod());
            preparedStmt.setLong(7, alumno.getDni());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    
    public boolean bajaDAO(JTable tabla){
        int seleccion;
        alumnos = new ArrayList(mostrarAlumnosDAO());
        try {
           
           this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
           this.consulta = this.connect.prepareStatement("DELETE FROM alumno WHERE alu_dni = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, alumnos.get(seleccion).getDni());
            consulta.executeUpdate();
            
            this.desconectar();
            return true;
            

        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
               return false;
        }
    }
    
    
    
    public boolean dniRepetidoDAO(AlumnoModelo alumno){
       
       try {
           this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from alumno where alu_dni=?");
            this.consulta.setLong(1, alumno.getDni());
            ResultSet hojadeResultados = consulta.executeQuery();
            if(hojadeResultados.next()){
                return false;              
            }
            this.desconectar();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return true;
   }
    
    
    public ArrayList<String> traeCodInscDAO() {    
        ArrayList<String> alu_insc_cod = new ArrayList<>();   
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select insc_cod from inscripcion");
            ResultSet resultados = consulta.executeQuery();
            alu_insc_cod.add("");
            while (resultados.next()) {
                alu_insc_cod.add(Long.toString(resultados.getLong(1)));
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alu_insc_cod;
    }

}
