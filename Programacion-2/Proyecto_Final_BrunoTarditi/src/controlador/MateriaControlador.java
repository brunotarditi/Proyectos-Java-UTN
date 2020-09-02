package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.MateriaVista;
import modelo.MateriaModelo;
import vista.MenuVista;

/**
 *
 * @author Bruno Tarditi
 */
public class MateriaControlador implements ActionListener, MouseListener {

    //Atributos de la clase
    private MateriaModelo materia_modelo;
    private MateriaVista materia_vista;
    private DefaultTableModel tabla_modelo;

    //Contructor vacío
    public MateriaControlador() {
    }

    //Constructor sobrecargado
    public MateriaControlador(MateriaModelo modelo, MateriaVista vista) {
        this.materia_modelo = modelo;
        this.materia_vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Materia");
        this.llenarFilas(this.materia_vista.getTablaMateria());
        botones_en_escucha();
        muestraDNI();
    }

    //Este metodo hace que los botones y la tabla de la vista del materia esten en escucha
    public void botones_en_escucha() {

        this.materia_vista.getBtnNuevaMat().addActionListener(this);
        this.materia_vista.getBtnActualizarMat().addActionListener(this);
        this.materia_vista.getBtnEliminarMat().addActionListener(this);
        this.materia_vista.getBtnVolverMat().addActionListener(this);
        this.materia_vista.getTablaMateria().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.materia_vista.getBtnNuevaMat())) {//PARA EL BOTON DE NUEVA MATERIA

            if (materia_modelo.validaCarga(this.materia_vista.getTxtCodMat().getText())) {

                JOptionPane.showMessageDialog(null, "Asigne un código a la materia.");
            } else if (materia_modelo.validaCarga(this.materia_vista.getTxtNombreMat().getText())) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la materia.");
            } else if (materia_modelo.validaCarga(String.valueOf(this.materia_vista.getCboDniProfeMat().getSelectedItem()))) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el DNI del profesor de la materia.");


            } else {
                this.materia_modelo.setMat_cod(Long.parseLong(this.materia_vista.getTxtCodMat().getText()));
                this.materia_modelo.setMat_nombre(this.materia_vista.getTxtNombreMat().getText());
                this.materia_modelo.setMat_prof_dni(Long.parseLong(this.materia_vista.getCboDniProfeMat().getSelectedItem().toString()));


                    if (this.materia_modelo.cargaDatos(materia_modelo)) {
                        JOptionPane.showMessageDialog(null, "Materia cargada correctamente.");

                        this.limpiaTabla(this.materia_vista.getTablaMateria());
                        llenarFilas(this.materia_vista.getTablaMateria());
                        limpiaCampos();
                    
                } else {
                        JOptionPane.showMessageDialog(null, "Materia repetida.");
                }

            }

        } else if (e.getSource().equals(this.materia_vista.getBtnActualizarMat())) {//BOTON PARA ACTUALIZAR UNA MATERIA

            this.materia_modelo.setMat_cod(Long.parseLong(this.materia_vista.getTxtCodMat().getText()));
            this.materia_modelo.setMat_nombre(this.materia_vista.getTxtNombreMat().getText());
            this.materia_modelo.setMat_prof_dni(Long.parseLong(this.materia_vista.getCboDniProfeMat().getSelectedItem().toString()));

            if (this.materia_modelo.modificaDatos(materia_modelo)) {
                JOptionPane.showMessageDialog(null, "Materia modificada correctamente.");
            }

            this.limpiaTabla(this.materia_vista.getTablaMateria());
            llenarFilas(this.materia_vista.getTablaMateria());
            limpiaCampos();

        } else if (e.getSource().equals(this.materia_vista.getBtnEliminarMat())) {//BOTON PARA ELIMINAR UN ALUMNO
            if (this.materia_modelo.bajaDatos(this.materia_vista.getTablaMateria())) {
                this.limpiaTabla(this.materia_vista.getTablaMateria());
                llenarFilas(this.materia_vista.getTablaMateria());
                JOptionPane.showMessageDialog(null, "Materia eliminada correctamente.");
                limpiaCampos();
                this.materia_vista.getTxtNombreMat().setEditable(true);
            }

        } else if (e.getSource().equals(this.materia_vista.getBtnVolverMat())) {//BOTON PARA VOLVER AL MENU
            MenuVista menu_vista = new MenuVista();
            MenuControlador menu_controlador = new MenuControlador(menu_vista);
            this.materia_vista.dispose();

        }

    }

    //Este metodo sirve para limpiar donde se ingresan los datos
    public void limpiaCampos() {
        this.materia_vista.getTxtCodMat().setText("");
        this.materia_vista.getTxtNombreMat().setText("");
        this.materia_vista.getCboDniProfeMat().setSelectedItem(0);
    }

    //Este metodo sirve para darle nombre a cada columna de la tabla
    public String[] nombreColumnas() {
        String[] Columna = {"Código de materia", "Nombre", "DNI de profesor"};
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
        ArrayList<MateriaModelo> materias;
        materias = this.materia_modelo.muestraDatos();
        this.limpiaTabla(this.materia_vista.getTablaMateria());
        Object datos[] = new Object[3];
        if (materias.size() > 0) {
            for (int i = 0; i < materias.size(); i++) {
                datos[0] = materias.get(i).getMat_cod();
                datos[1] = materias.get(i).getMat_nombre();
                datos[2] = materias.get(i).getMat_prof_dni();
                tabla_modelo.addRow(datos);
            }
        }
        tabla.setModel(tabla_modelo);
        materias.clear();
    }

    public void muestraDNI() {
        ArrayList<String> prof_dni = this.materia_modelo.matDniProf();
        Iterator<String> dniIterator = prof_dni.iterator();
        while (dniIterator.hasNext()) {
            this.materia_vista.getCboDniProfeMat().addItem(dniIterator.next());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == 1) {
            int fila = this.materia_vista.getTablaMateria().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.materia_vista.getTxtCodMat().setText(String.valueOf(this.materia_vista.getTablaMateria().getValueAt(fila, 0)));
                this.materia_vista.getTxtNombreMat().setText(String.valueOf(this.materia_vista.getTablaMateria().getValueAt(fila, 1)));
                this.materia_vista.getCboDniProfeMat().setSelectedItem(String.valueOf(this.materia_vista.getTablaMateria().getValueAt(fila, 2)));

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
