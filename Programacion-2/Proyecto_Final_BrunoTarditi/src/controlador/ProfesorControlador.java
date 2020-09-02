package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProfesorModelo;
import vista.MenuVista;
import vista.ProfesorVista;

/**
 *
 * @author Bruno Tarditi
 */
public class ProfesorControlador implements ActionListener, MouseListener {

    //Atributos de la clase
    private ProfesorModelo profesor_modelo;
    private ProfesorVista profesor_vista;
    private DefaultTableModel tabla_modelo;

    //Contructor vacío
    public ProfesorControlador() {
    }

    //Constructor sobrecargado
    public ProfesorControlador(ProfesorModelo modelo, ProfesorVista vista) {

        this.profesor_modelo = modelo;
        this.profesor_vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Profesor");
        this.llenarFilas(this.profesor_vista.getTablaProfe());
        botones_en_escucha();
        limpiaCampos();

    }

    //Este metodo hace que los botones y la tabla de la vista del profesor esten en escucha
    public void botones_en_escucha() {

        this.profesor_vista.getBtnNuevoProfe().addActionListener(this);
        this.profesor_vista.getBtnActualizarProfe().addActionListener(this);
        this.profesor_vista.getBtnEliminaProfe().addActionListener(this);
        this.profesor_vista.getBtnVolverProfe().addActionListener(this);
        this.profesor_vista.getTablaProfe().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.profesor_vista.getBtnNuevoProfe())) { //PARA EL BOTON DE NUEVO PROFESOR

            //Se validan que ingresen los datos requeridos de manera obligatoria
            if (profesor_modelo.validaCarga(this.profesor_vista.getTxtDniProfe().getText())) {
                JOptionPane.showMessageDialog(null, "El DNI es obligatorio.");
            } else if (profesor_modelo.validaCarga(this.profesor_vista.getTxtNombreProfe().getText())) {
                JOptionPane.showMessageDialog(null, "El nombre es obligatorio.");
            } else if (profesor_modelo.validaCarga(this.profesor_vista.getTxtApellidoProfe().getText())) {
                JOptionPane.showMessageDialog(null, "El apellido es obligatorio.");
            } else if (this.profesor_vista.getDateProfe().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha.");

                //Valida que el dni sea numerico
            } else if (profesor_modelo.validaDni(this.profesor_vista.getTxtDniProfe().getText())) {
                JOptionPane.showMessageDialog(null, "DNI no válido.");
                //Si al parece todo está bien se carga un nuevo profesor
            } else {
                this.profesor_modelo.setDniProfe(Long.parseLong(this.profesor_vista.getTxtDniProfe().getText()));
                this.profesor_modelo.setNombre(this.profesor_vista.getTxtNombreProfe().getText());
                this.profesor_modelo.setApellido(this.profesor_vista.getTxtApellidoProfe().getText());
                java.util.Date fecha = this.profesor_vista.getDateProfe().getDate();
                Date fechaSQL = new Date(fecha.getTime());
                this.profesor_modelo.setFecha(fechaSQL);
                this.profesor_modelo.setDomicilio(this.profesor_vista.getTxtDomicProfe().getText());
                this.profesor_modelo.setTelefono(profesor_vista.getTxtTelProfe().getText());

                //Se asegura que el dni no sea uno repetido
                if (profesor_modelo.dniRepetido(profesor_modelo)) {
                    if (profesor_modelo.cargaDatos(profesor_modelo)) { //Si todo hasta aca esta bien, el profesor se carga
                        JOptionPane.showMessageDialog(null, "El profesor ha sido cargado correctamente.");
                    }

                    this.limpiaTabla(this.profesor_vista.getTablaProfe());
                    llenarFilas(this.profesor_vista.getTablaProfe());
                    limpiaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Profesor repetido.");
                }

            }

        } else if (e.getSource().equals(this.profesor_vista.getBtnActualizarProfe())) { //BOTON PARA ACTUALIZAR UN PROFESOR
            this.profesor_modelo.setDniProfe(Long.parseLong(this.profesor_vista.getTxtDniProfe().getText()));
            this.profesor_modelo.setNombre(this.profesor_vista.getTxtNombreProfe().getText());
            this.profesor_modelo.setApellido(this.profesor_vista.getTxtApellidoProfe().getText());
            java.util.Date fecha = this.profesor_vista.getDateProfe().getDate();
            Date fechaSQL = new Date(fecha.getTime());
            this.profesor_modelo.setFecha(fechaSQL);
            this.profesor_modelo.setDomicilio(this.profesor_vista.getTxtDomicProfe().getText());
            this.profesor_modelo.setTelefono(profesor_vista.getTxtTelProfe().getText());

            if (this.profesor_modelo.modificaDatos(profesor_modelo)) {
                JOptionPane.showMessageDialog(null, "El profesor fue modificado correctamente.");
            }
            this.limpiaTabla(this.profesor_vista.getTablaProfe());
            llenarFilas(this.profesor_vista.getTablaProfe());
            limpiaCampos();
            this.profesor_vista.getTxtDniProfe().setEditable(true);

        } else if (e.getSource().equals(this.profesor_vista.getBtnEliminaProfe())) {//BOTON PARA ELIMINAR UN PROFESOR
            if (this.profesor_modelo.bajaDatos(this.profesor_vista.getTablaProfe())) {

                this.limpiaTabla(this.profesor_vista.getTablaProfe());
                llenarFilas(this.profesor_vista.getTablaProfe());
                JOptionPane.showMessageDialog(null, "El profesor seleccionado fue eliminado correctamente");
                limpiaCampos();
                this.profesor_vista.getTxtDniProfe().setEditable(true);
            }
        } else if (e.getSource().equals(this.profesor_vista.getBtnVolverProfe())) {//BOTON PARA VOLVER AL MENU
            MenuVista menu_vista = new MenuVista();
            MenuControlador menu_controlador = new MenuControlador(menu_vista);
            this.profesor_vista.dispose();
        }
    }

    //Este metodo sirve para limpiar donde se ingresan los datos
    public void limpiaCampos() {
        this.profesor_vista.getTxtDniProfe().setText("");
        this.profesor_vista.getTxtNombreProfe().setText("");
        this.profesor_vista.getTxtApellidoProfe().setText("");
        this.profesor_vista.getDateProfe().setDate(null);
        this.profesor_vista.getTxtDomicProfe().setText("");
        this.profesor_vista.getTxtTelProfe().setText("");
    }

    //Este metodo sirve para darle nombre a cada columna de la tabla
    public String[] nombreColumnas() {
        String[] Columna = {"DNI", "Nombre", "Apellido", "Fecha de nacimiento", "Domicilio", "Teléfono"};
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
        ArrayList<ProfesorModelo> prefesores;
        prefesores = this.profesor_modelo.muestraDatos();
        this.limpiaTabla(this.profesor_vista.getTablaProfe());
        Object datos[] = new Object[6];
        if (prefesores.size() > 0) {
            for (int i = 0; i < prefesores.size(); i++) {
                datos[0] = prefesores.get(i).getDniProfe();
                datos[1] = prefesores.get(i).getNombre();
                datos[2] = prefesores.get(i).getApellido();
                datos[3] = prefesores.get(i).getFecha();
                datos[4] = prefesores.get(i).getDomicilio();
                datos[5] = prefesores.get(i).getTelefono();
                tabla_modelo.addRow(datos);
            }
        }
        tabla.setModel(tabla_modelo);
        prefesores.clear();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.profesor_vista.getTablaProfe().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.profesor_vista.getTxtDniProfe().setText(String.valueOf(this.profesor_vista.getTablaProfe().getValueAt(fila, 0)));
                this.profesor_vista.getTxtDniProfe().setEditable(false);
                this.profesor_vista.getTxtNombreProfe().setText(String.valueOf(this.profesor_vista.getTablaProfe().getValueAt(fila, 1)));
                this.profesor_vista.getTxtApellidoProfe().setText(String.valueOf(this.profesor_vista.getTablaProfe().getValueAt(fila, 2)));
                String fecha = String.valueOf(this.profesor_vista.getTablaProfe().getValueAt(fila, 3));
                try {

                    java.util.Date fecha_dos = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                    this.profesor_vista.getDateProfe().setDate(fecha_dos);

                } catch (ParseException parse) {
                    Logger.getLogger(ProfesorControlador.class.getName()).log(Level.SEVERE, null, parse);
                }
                this.profesor_vista.getTxtDomicProfe().setText(String.valueOf(this.profesor_vista.getTablaProfe().getValueAt(fila, 4)));
                this.profesor_vista.getTxtTelProfe().setText(String.valueOf(this.profesor_vista.getTablaProfe().getValueAt(fila, 5)));

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
