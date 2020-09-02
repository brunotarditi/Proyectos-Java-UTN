package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.InscripcionModelo;
import vista.InscripcionVista;
import vista.MenuVista;

/**
 *
 * @author Bruno Tarditi
 */
public class InscripcionControlador implements ActionListener, MouseListener {

    private InscripcionModelo insc_modelo;
    private InscripcionVista insc_vista;
    private DefaultTableModel tabla_modelo;

    public InscripcionControlador() {
    }

    public InscripcionControlador(InscripcionModelo modelo, InscripcionVista vista) {

        this.insc_modelo = modelo;
        this.insc_vista = vista;

        vista.setVisible(true);
        vista.setTitle("Inscripción");
        vista.setLocationRelativeTo(null);
        this.llenarFilas(this.insc_vista.getTablaInsc());
        muestraCarCod();
        botones_en_escucha();

    }

    public void botones_en_escucha() {

        this.insc_vista.getBtnNuevaIns().addActionListener(this);
        this.insc_vista.getBtnActualizarIns().addActionListener(this);
        this.insc_vista.getBtnEliminarIns().addActionListener(this);
        this.insc_vista.getBtnVolverIns().addActionListener(this);
        this.insc_vista.getTablaInsc().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.insc_vista.getBtnNuevaIns())) {//PARA EL BOTON DE NUEVA INSCRIPCION
            if (insc_modelo.validaCarga(this.insc_vista.getTxtCodInsc().getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese un código de inscripción.");
            } else if (insc_modelo.validaCarga(this.insc_vista.getTxtNombreInsc().getText())) {
                JOptionPane.showMessageDialog(null, "El nombre es obligatorio.");
            } else if (this.insc_vista.getDateInsc().getDate() == null) {
                JOptionPane.showMessageDialog(null, "La fecha es obligatoria.");
            } else if (insc_modelo.validaCarga(this.insc_vista.getCboInsc().getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un código de carrera.");
            } else {

                this.insc_modelo.setInsc_nombre(this.insc_vista.getTxtNombreInsc().getText());
                java.util.Date fecha = this.insc_vista.getDateInsc().getDate();
                java.sql.Date dateSQL = new java.sql.Date(fecha.getTime());
                this.insc_modelo.setInsc_fecha(dateSQL);
                this.insc_modelo.setInsc_car_cod(Long.parseLong(this.insc_vista.getCboInsc().getSelectedItem().toString()));

                if (this.insc_modelo.cargaDatos(insc_modelo)) {
                    JOptionPane.showMessageDialog(null, "Inscripción cargada correctamente");
                }

                limpiarTabla(this.insc_vista.getTablaInsc());
                llenarFilas(this.insc_vista.getTablaInsc());
                limpiaCuadros();

            }

        } else if (e.getSource().equals(this.insc_vista.getBtnActualizarIns())) {//BOTON PARA ACTUALIZAR UNA INSCRIPCION
            this.insc_modelo.setInsc_cod(Long.parseLong(this.insc_vista.getTxtCodInsc().getText()));
            this.insc_modelo.setInsc_nombre(this.insc_vista.getTxtNombreInsc().getText());
            Date fecha = this.insc_vista.getDateInsc().getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            this.insc_modelo.setInsc_fecha(fechaSQL);
            this.insc_modelo.setInsc_car_cod(Long.parseLong(this.insc_vista.getCboInsc().getSelectedItem().toString()));

            if (this.insc_modelo.modificaDatos(insc_modelo)) {
                JOptionPane.showMessageDialog(null, "Inscripción modificada correctamente");

            }
            limpiarTabla(this.insc_vista.getTablaInsc());
            llenarFilas(this.insc_vista.getTablaInsc());
            limpiaCuadros();

        } else if (e.getSource().equals(this.insc_vista.getBtnEliminarIns())) {//BOTON PARA ELIMINAR UNA INSCRIPCION

            if (this.insc_modelo.bajaDatos(this.insc_vista.getTablaInsc())) {

                limpiarTabla(this.insc_vista.getTablaInsc());
                llenarFilas(this.insc_vista.getTablaInsc());
                JOptionPane.showMessageDialog(null, "Inscripción eliminada correctamente");
                limpiaCuadros();
            }

        } else if (e.getSource().equals(this.insc_vista.getBtnVolverIns())) {//BOTON PARA VOLVER AL MENU
            MenuVista menu_vista = new MenuVista();
            MenuControlador menu_controlador = new MenuControlador(menu_vista);
            this.insc_vista.dispose();
        }
    }

    //Este metodo sirve para darle nombre a cada columna de la tabla
    public String[] dameColumnas() {
        String[] Columna = {"Código de inscripción", "Nombre", "Fecha de inscripción", "Código de carrera"};
        return Columna;
    }

    public void limpiarTabla(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }
    //Este metodo llena las filas de la tabla
    public void llenarFilas(JTable tabla) {
        tabla_modelo = new DefaultTableModel(null, dameColumnas());
        ArrayList<InscripcionModelo> inscripciones;
        inscripciones = this.insc_modelo.muestraDatos();
        this.limpiarTabla(this.insc_vista.getTablaInsc());
        Object datos[] = new Object[4];
        if (inscripciones.size() > 0) {
            for (int i = 0; i < inscripciones.size(); i++) {
                datos[0] = inscripciones.get(i).getInsc_cod();
                datos[1] = inscripciones.get(i).getInsc_nombre();
                datos[2] = inscripciones.get(i).getInsc_fecha();
                datos[3] = inscripciones.get(i).getInsc_car_cod();
                tabla_modelo.addRow(datos);
            }
        }

        tabla.setModel(tabla_modelo);
        inscripciones.clear();
    }

    //Este metodo sirve para limpiar donde se ingresan los datos
    public void limpiaCuadros() {
        this.insc_vista.getTxtCodInsc().setText("");
        this.insc_vista.getTxtNombreInsc().setText("");
        this.insc_vista.getDateInsc().setDate(null);
        this.insc_vista.getCboInsc().setSelectedItem(0);
    }

    //Muestra los distintos códigos de inscripciones asociados a través de la clave foranea
    public void muestraCarCod() {
        ArrayList<String> insc_car_cod = this.insc_modelo.RetornaInscCarCod();
        Iterator<String> carIterator = insc_car_cod.iterator();
        while (carIterator.hasNext()) {
            this.insc_vista.getCboInsc().addItem(carIterator.next());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == 1) {
            int fila = this.insc_vista.getTablaInsc().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.insc_vista.getTxtCodInsc().setText(String.valueOf(this.insc_vista.getTablaInsc().getValueAt(fila, 0)));
                this.insc_vista.getTxtNombreInsc().setText(String.valueOf(this.insc_vista.getTablaInsc().getValueAt(fila, 1)));
                String fecha = String.valueOf(this.insc_vista.getTablaInsc().getValueAt(fila, 2));
                try {

                    Date fecha_dos = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                    this.insc_vista.getDateInsc().setDate(fecha_dos);

                } catch (ParseException parse) {
                    Logger.getLogger(InscripcionControlador.class.getName()).log(Level.SEVERE, null, parse);
                }
                this.insc_vista.getCboInsc().setSelectedItem(String.valueOf(this.insc_vista.getTablaInsc().getValueAt(fila, 3)));

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
