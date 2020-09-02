package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnoModelo;
import vista.AlumnoVista;
import vista.MenuVista;

/**
 *
 * @author Bruno Tarditi
 */
public class AlumnoControlador implements ActionListener, MouseListener {

    //Atributos de la clase
    private AlumnoVista alumno_vista;
    private AlumnoModelo alumno_modelo;
    private DefaultTableModel tabla_modelo;

     //Contructor vacío
    public AlumnoControlador() {
    }
    
    

    //Constructor sobrecargado
    public AlumnoControlador(AlumnoModelo modelo, AlumnoVista vista) {
        this.alumno_modelo = modelo;
        this.alumno_vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Alumnos");
        this.llenarFilas(this.alumno_vista.getTablaAlumno());
        botones_en_escucha();
        muestraCodigos();
        
    }

    //Este metodo hace que los botones y la tabla de la vista del profesor esten en escucha
    public void botones_en_escucha() {

        this.alumno_vista.getBtnNuevoAlumno().addActionListener(this);
        this.alumno_vista.getBtnActualizarAlumno().addActionListener(this);
        this.alumno_vista.getBtnEliminarAlumno().addActionListener(this);
        this.alumno_vista.getBtnVolverAlumno().addActionListener(this);
        this.alumno_vista.getTablaAlumno().addMouseListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource().equals(this.alumno_vista.getBtnNuevoAlumno())) {//PARA EL BOTON DE NUEVO ALUMNO
            if (alumno_modelo.validaCarga(this.alumno_vista.getTxtDniAlumno().getText())) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un DNI para el alumno.");
            } else if (alumno_modelo.validaCarga(this.alumno_vista.getTxtNombreAlumno().getText())) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.");
            } else if (alumno_modelo.validaCarga(this.alumno_vista.getTxtApellidoAlumno().getText())) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un apellido.");
            } else if (alumno_vista.getDateAlumno().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha.");
            } else if (alumno_modelo.validaCarga(this.alumno_vista.getCboCodInsc().getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un código de inscripción.");
            } else if (alumno_modelo.validaDni(this.alumno_vista.getTxtDniAlumno().getText())) {
                JOptionPane.showMessageDialog(null, "El DNI no es válido.");

            } else {
                this.alumno_modelo.setDni(Long.parseLong(this.alumno_vista.getTxtDniAlumno().getText()));
                this.alumno_modelo.setNombre(this.alumno_vista.getTxtNombreAlumno().getText());
                this.alumno_modelo.setApellido(this.alumno_vista.getTxtApellidoAlumno().getText());
                java.util.Date fecha = this.alumno_vista.getDateAlumno().getDate();
                Date fechaSQL = new Date(fecha.getTime());
                this.alumno_modelo.setFecha(fechaSQL);
                this.alumno_modelo.setDomicilio(this.alumno_vista.getTxtDomicilioAlumno().getText());
                this.alumno_modelo.setTelefono(this.alumno_vista.getTxtTelAlumno().getText());
                this.alumno_modelo.setInsc_cod(Long.parseLong(this.alumno_vista.getCboCodInsc().getSelectedItem().toString()));

                if (alumno_modelo.dniRepetido(alumno_modelo)) {
                    if (this.alumno_modelo.cargaDatos(alumno_modelo)) {
                        JOptionPane.showMessageDialog(null, "El alumno fue cargado correctamente.");
                    }
                    this.limpiaTabla(this.alumno_vista.getTablaAlumno());
                    llenarFilas(this.alumno_vista.getTablaAlumno());
                    limpiaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Alumno repetido");
                }
            }

        } else if (evento.getSource().equals(this.alumno_vista.getBtnActualizarAlumno())) {//BOTON PARA ACTUALIZAR UN ALUMNO

            this.alumno_modelo.setDni(Long.parseLong(this.alumno_vista.getTxtDniAlumno().getText()));
            this.alumno_modelo.setNombre(this.alumno_vista.getTxtNombreAlumno().getText());
            this.alumno_modelo.setApellido(this.alumno_vista.getTxtApellidoAlumno().getText());
            java.util.Date fecha = this.alumno_vista.getDateAlumno().getDate();
            Date sqlDate = new Date(fecha.getTime());
            this.alumno_modelo.setFecha(sqlDate);
            this.alumno_modelo.setDomicilio(this.alumno_vista.getTxtDomicilioAlumno().getText());
            this.alumno_modelo.setTelefono(this.alumno_vista.getTxtTelAlumno().getText());
            this.alumno_modelo.setInsc_cod(Long.parseLong(this.alumno_vista.getCboCodInsc().getSelectedItem().toString()));

            if (this.alumno_modelo.modificaDatos(alumno_modelo)) {
                JOptionPane.showMessageDialog(null, "El alumno fue modificado correctamente.");

            }
            this.limpiaTabla(this.alumno_vista.getTablaAlumno());
            llenarFilas(this.alumno_vista.getTablaAlumno());
            limpiaCampos();
            this.alumno_vista.getTxtDniAlumno().setEditable(true);

        } else if (evento.getSource().equals(this.alumno_vista.getBtnEliminarAlumno())) { //BOTON PARA ELIMINAR UN ALUMNO

            if (this.alumno_modelo.bajaDatos(this.alumno_vista.getTablaAlumno())) {

                this.limpiaTabla(this.alumno_vista.getTablaAlumno());
                llenarFilas(this.alumno_vista.getTablaAlumno());
                JOptionPane.showMessageDialog(null, "El alumno fue eliminado correctamente");
                limpiaCampos();
                this.alumno_vista.getTxtDniAlumno().setEditable(true);
            }

        } else if (evento.getSource().equals(this.alumno_vista.getBtnVolverAlumno())) {//BOTON PARA VOLVER AL MENU
            MenuVista menu_vista = new MenuVista();
            MenuControlador menu_controlador = new MenuControlador(menu_vista);
            this.alumno_vista.dispose();
        }

    }

    //Este metodo sirve para darle nombre a cada columna de la tabla
    public String[] nombreColumnas() {
        String[] Columna = {"DNI", "Nombre", "Apellido", "Fecha de nacimiento", "Domicilio", "Teléfono", "Código de Inscripción"};
        return Columna;
    }

    public void limpiaTabla(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

     //Este metodo llena las filas de la tabla
    public void llenarFilas(JTable tabla) {
        tabla_modelo = new DefaultTableModel(null, nombreColumnas());
        ArrayList<AlumnoModelo> alumnos;
        alumnos = this.alumno_modelo.muestraDatos();
        this.limpiaTabla(this.alumno_vista.getTablaAlumno());
        Object datos[] = new Object[7];
        if (alumnos.size() > 0) {
            for (int i = 0; i < alumnos.size(); i++) {
                datos[0] = alumnos.get(i).getDni();
                datos[1] = alumnos.get(i).getNombre();
                datos[2] = alumnos.get(i).getApellido();
                datos[3] = alumnos.get(i).getFecha();
                datos[4] = alumnos.get(i).getDomicilio();
                datos[5] = alumnos.get(i).getTelefono();
                datos[6] = alumnos.get(i).getInsc_cod();
                tabla_modelo.addRow(datos);
            }
        }

        tabla.setModel(tabla_modelo);
        alumnos.clear();
    }

    //Este metodo sirve para limpiar donde se ingresan los datos
    public void limpiaCampos() {
        this.alumno_vista.getTxtDniAlumno().setText("");
        this.alumno_vista.getTxtNombreAlumno().setText("");
        this.alumno_vista.getTxtApellidoAlumno().setText("");
        this.alumno_vista.getDateAlumno().setDate(null);
        this.alumno_vista.getTxtDomicilioAlumno().setText("");
        this.alumno_vista.getTxtTelAlumno().setText("");
        this.alumno_vista.getCboCodInsc().setSelectedIndex(0);
    }

    //Muestra los distintos códigos de inscripciones asociados a través de la clave foranea
    public void muestraCodigos() {
        ArrayList<String> insc_cod = this.alumno_modelo.traeCodInsc();
        Iterator<String> codIterator = insc_cod.iterator();
        while (codIterator.hasNext()) {
            this.alumno_vista.getCboCodInsc().addItem(codIterator.next());
        }
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        if (evento.getButton() == 1) {
            int fila = this.alumno_vista.getTablaAlumno().rowAtPoint(evento.getPoint());
            if (fila > -1) {
                this.alumno_vista.getTxtDniAlumno().setText(String.valueOf(this.alumno_vista.getTablaAlumno().getValueAt(fila, 0)));
                this.alumno_vista.getTxtDniAlumno().setEditable(false);
                this.alumno_vista.getTxtNombreAlumno().setText(String.valueOf(this.alumno_vista.getTablaAlumno().getValueAt(fila, 1)));
                this.alumno_vista.getTxtApellidoAlumno().setText(String.valueOf(this.alumno_vista.getTablaAlumno().getValueAt(fila, 2)));
                String fecha = String.valueOf(this.alumno_vista.getTablaAlumno().getValueAt(fila, 3));
                try {

                    java.util.Date fecha_dos = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                    this.alumno_vista.getDateAlumno().setDate(fecha_dos);

                } catch (ParseException parse) {
                    Logger.getLogger(AlumnoControlador.class.getName()).log(Level.SEVERE, null, parse);
                }
                this.alumno_vista.getTxtDomicilioAlumno().setText(String.valueOf(this.alumno_vista.getTablaAlumno().getValueAt(fila, 4)));
                this.alumno_vista.getTxtTelAlumno().setText(String.valueOf(this.alumno_vista.getTablaAlumno().getValueAt(fila, 5)));
                this.alumno_vista.getCboCodInsc().setSelectedItem(String.valueOf(this.alumno_vista.getTablaAlumno().getValueAt(fila, 6)));

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
