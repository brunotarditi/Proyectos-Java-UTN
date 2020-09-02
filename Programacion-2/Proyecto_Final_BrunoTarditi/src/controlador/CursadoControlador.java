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
import modelo.CursadoModelo;
import vista.CursadoVista;
import vista.MenuVista;

/**
 *
 * @author Bruno Tarditi
 */
public class CursadoControlador implements ActionListener, MouseListener {

    private CursadoModelo cursado_modelo;
    private CursadoVista cursado_vista;
    private DefaultTableModel tabla_modelo;

    public CursadoControlador() {
    }

    public CursadoControlador(CursadoModelo modelo, CursadoVista vista) {

        this.cursado_modelo = modelo;
        this.cursado_vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Cursado");
        this.llenarFilas(this.cursado_vista.getTablaCursado());
        botones_en_escucha();
        muestraAluDNI();
        muestraMatCod();
    }

    public void botones_en_escucha() {

        this.cursado_vista.getBtnNuevoCursado().addActionListener(this);
        this.cursado_vista.getBtnEliminarCursado().addActionListener(this);
        this.cursado_vista.getBtnActualizarCursado().addActionListener(this);
        this.cursado_vista.getBtnVolverCursado().addActionListener(this);
        this.cursado_vista.getTablaCursado().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.cursado_vista.getBtnNuevoCursado())) {
            if (this.cursado_modelo.validaCarga(this.cursado_vista.getCboDniAluCur().getSelectedItem().toString())) {

                JOptionPane.showMessageDialog(null, "Seleccione un dni de alumno para el cursado.");
            } else if (this.cursado_modelo.validaCarga(this.cursado_vista.getCboCodMat().getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Seleccione un código de cursado para el cursado.");
            } else {
                this.cursado_modelo.setCur_alu_dni(Long.parseLong(this.cursado_vista.getCboDniAluCur().getSelectedItem().toString()));
                this.cursado_modelo.setCur_mat_cod(Long.parseLong(this.cursado_vista.getCboCodMat().getSelectedItem().toString()));
                this.cursado_modelo.setCur_nota(Integer.parseInt(this.cursado_vista.getTxtNotaCursado().getText()));

                if (this.cursado_modelo.cargaDatos(cursado_modelo)) {
                    JOptionPane.showMessageDialog(null, "Cursado cargado correctamente.");

                    this.limpiaTabla(this.cursado_vista.getTablaCursado());
                    llenarFilas(this.cursado_vista.getTablaCursado());
                    limpiaCampos();
                }
            }

        } else if (e.getSource().equals(this.cursado_vista.getBtnActualizarCursado())) {

            this.cursado_modelo.setCur_alu_dni(Long.parseLong(this.cursado_vista.getCboDniAluCur().getSelectedItem().toString()));
            this.cursado_modelo.setCur_mat_cod(Long.parseLong(this.cursado_vista.getCboCodMat().getSelectedItem().toString()));
            this.cursado_modelo.setCur_nota(Integer.parseInt(this.cursado_vista.getTxtNotaCursado().getText()));
            
            if (this.cursado_modelo.modificaDatos(cursado_modelo)) {
                JOptionPane.showMessageDialog(null, "Cursado modificado correctamente.");
            }

            this.limpiaTabla(this.cursado_vista.getTablaCursado());
            llenarFilas(this.cursado_vista.getTablaCursado());
            limpiaCampos();

        } else if (e.getSource().equals(this.cursado_vista.getBtnEliminarCursado())) {

            if (this.cursado_modelo.bajaDatos(this.cursado_vista.getTablaCursado())) {
                this.limpiaTabla(this.cursado_vista.getTablaCursado());
                llenarFilas(this.cursado_vista.getTablaCursado());
                JOptionPane.showMessageDialog(null, "El cursado fue eliminado correctamente.");
                limpiaCampos();
            }

        } else if (e.getSource().equals(this.cursado_vista.getBtnVolverCursado())) {
            MenuVista menu_vista = new MenuVista();
            MenuControlador menu_controlador = new MenuControlador(menu_vista);
            this.cursado_vista.dispose();

        }
    }

    //Este metodo sirve para limpiar donde se ingresan los datos
    public void limpiaCampos() {
        this.cursado_vista.getCboDniAluCur().setSelectedItem(0);
        this.cursado_vista.getCboDniAluCur().setSelectedItem(0);
        this.cursado_vista.getTxtNotaCursado().setText("");
    }

    //Este metodo sirve para darle nombre a cada columna de la tabla
    public String[] nombreColumnas() {
        String[] Columna = {"DNI de alumno", "Código de cursado", "Nota"};
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
        ArrayList<CursadoModelo> cursados;
        cursados = this.cursado_modelo.muestraDatos();
        this.limpiaTabla(this.cursado_vista.getTablaCursado());
        Object datos[] = new Object[3];
        if (cursados.size() > 0) {
            for (int i = 0; i < cursados.size(); i++) {
                datos[0] = cursados.get(i).getCur_alu_dni();
                datos[1] = cursados.get(i).getCur_mat_cod();
                datos[2] = cursados.get(i).getCur_nota();
                tabla_modelo.addRow(datos);
            }
        }
        tabla.setModel(tabla_modelo);
        cursados.clear();
    }

    public void muestraAluDNI() {
        ArrayList<String> alu_dni = this.cursado_modelo.retornaAluDNI();
        Iterator<String> dniIterator = alu_dni.iterator();
        while (dniIterator.hasNext()) {
            this.cursado_vista.getCboDniAluCur().addItem(dniIterator.next());
        }
    }

    public void muestraMatCod() {
        ArrayList<String> mat_cod = this.cursado_modelo.retornaMatCod();
        Iterator<String> codIterator = mat_cod.iterator();
        while (codIterator.hasNext()) {
            this.cursado_vista.getCboCodMat().addItem(codIterator.next());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == 1) {
            int fila = this.cursado_vista.getTablaCursado().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.cursado_vista.getCboDniAluCur().setSelectedItem(String.valueOf(this.cursado_vista.getTablaCursado().getValueAt(fila, 0)));
                this.cursado_vista.getCboCodMat().setSelectedItem(String.valueOf(this.cursado_vista.getTablaCursado().getValueAt(fila, 1)));
                this.cursado_vista.getTxtNotaCursado().setText(String.valueOf(this.cursado_vista.getTablaCursado().getValueAt(fila, 2)));

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
