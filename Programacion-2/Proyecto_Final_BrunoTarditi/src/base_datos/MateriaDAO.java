package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.MateriaModelo;

/**
 *
 * @author Bruno Tarditi
 */
public class MateriaDAO extends SQLQuery {

    private ArrayList<MateriaModelo> materias;
    private MateriaModelo materia;

    public ArrayList<MateriaModelo> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<MateriaModelo> materias) {
        this.materias = materias;
    }

    public boolean cargarDatosDAO(MateriaModelo materia) {

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO materia (mat_cod, mat_nombre, mat_prof_dni) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement(sql);
            preparedStmt.setLong(1, materia.getMat_cod());
            preparedStmt.setString(2, materia.getMat_nombre());
            preparedStmt.setLong(3, materia.getMat_prof_dni());
            preparedStmt.execute();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public ArrayList<MateriaModelo> mostrarMateriasDAO() {

        materias = new ArrayList();

        try {

            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select * from materia");
            ResultSet hoja_de_resultado = consulta.executeQuery();
            while (hoja_de_resultado.next()) {
                materia = new MateriaModelo();
                materia.setMat_cod(hoja_de_resultado.getLong(1));
                materia.setMat_nombre(hoja_de_resultado.getString(2));
                materia.setMat_prof_dni(hoja_de_resultado.getLong(3));
                materias.add(materia);

            }

            this.desconectar();

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return materias;
    }
    
    
    public boolean modificaDAO(MateriaModelo materia) {    
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            PreparedStatement preparedStmt = (PreparedStatement) this.connect.prepareStatement("UPDATE materia SET mat_nombre=?, mat_prof_dni=? WHERE mat_cod=?");
            preparedStmt.setString(1, materia.getMat_nombre());
            preparedStmt.setLong(2, materia.getMat_prof_dni());
            preparedStmt.setLong(3, materia.getMat_cod());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public boolean bajaDAO(JTable tabla){
        int seleccion;
        materias = new ArrayList(mostrarMateriasDAO());
        try {
           
           this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
           this.consulta = this.connect.prepareStatement("DELETE FROM materia WHERE mat_cod = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, materias.get(seleccion).getMat_cod());
            consulta.executeUpdate();
            
            this.desconectar();
            return true;
            

        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
               return false;
        }
    }
    
    
    
    public ArrayList<String> muestraDniProf() {    
        ArrayList<String> mat_prof_dni = new ArrayList<>();   
        try {
            this.conectar("127.0.0.1", "SGA_2020", "root", "1234");
            this.consulta = this.connect.prepareStatement("select prof_dni from profesor");
            ResultSet resultados = consulta.executeQuery();
            mat_prof_dni.add("");
            while (resultados.next()) {
                mat_prof_dni.add(Long.toString(resultados.getLong(1)));
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mat_prof_dni;
    }

}
