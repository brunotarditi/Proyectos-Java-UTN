package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CarreraModelo;
import vista.CarreraVista;
import vista.MenuVista;

/**
 *
 * @author Bruno Tarditi
 */
public class CarreraControlador implements ActionListener, MouseListener {

    //Atributos de la clase
    private CarreraModelo carrera_modelo;
    private CarreraVista carrera_vista;
    private DefaultTableModel tabla_modelo;

    //Contructor vacío
    public CarreraControlador() {
    }

    //Constructor sobrecargado
    public CarreraControlador(CarreraModelo modelo, CarreraVista vista) {
        this.carrera_modelo = modelo;
        this.carrera_vista = vista;
        vista.setVisible(true);
        vista.setTitle("Carrera");
        vista.setLocationRelativeTo(null);
        this.llenarFilas(this.carrera_vista.getTablaCarrera());
        botones_en_escucha();
    }

    //Este metodo hace que los botones y la tabla de la vista del profesor esten en escucha
    public void botones_en_escucha() {

        this.carrera_vista.getBtnNuevaCarrera().addActionListener(this);
        this.carrera_vista.getBtnActualizarCarrera().addActionListener(this);
        this.carrera_vista.getBtnEliminarCarrera().addActionListener(this);
        this.carrera_vista.getBtnVolverCarrera().addActionListener(this);
        this.carrera_vista.getTablaCarrera().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.carrera_vista.getBtnNuevaCarrera())) {//PARA EL BOTON DE NUEVA CARRERA
            if (carrera_modelo.validaCarga(this.carrera_vista.getTxtNombreCarrera().getText())) {
                JOptionPane.showMessageDialog(null, "El nombre de la carrera es obligatorio.");
            } else if (carrera_modelo.validaCarga(this.carrera_vista.getTxtDuracionCarrera().getText())) {
                JOptionPane.showMessageDialog(null, "La duración de la carrera es obligatorio.");
            } else if (carrera_modelo.validaCarga(this.carrera_vista.getTxtCodCarrera().getText())) {
                JOptionPane.showMessageDialog(null, "El código de la carrera es obligatorio.");
            } else {

                this.carrera_modelo.setNombre(this.carrera_vista.getTxtNombreCarrera().getText());
                this.carrera_modelo.setDuracion(Long.parseLong(this.carrera_vista.getTxtDuracionCarrera().getText()));

                if (carrera_modelo.carreraRepetida(carrera_modelo)) {

                    if (this.carrera_modelo.cargaDatos(carrera_modelo)) {
                        JOptionPane.showMessageDialog(null, "Carrera cargada correctamente");
                    }

                    this.limpiarTabla(this.carrera_vista.getTablaCarrera());
                    llenarFilas(this.carrera_vista.getTablaCarrera());
                    limpiaCuadros();

                } else {
                    JOptionPane.showMessageDialog(null, "Carrera repetida.");
                }
            }

        } else if (e.getSource().equals(this.carrera_vista.getBtnActualizarCarrera())) {//BOTON PARA ACTUALIZAR LA CARRERA
            this.carrera_modelo.setCod_carrera(Long.parseLong(this.carrera_vista.getTxtCodCarrera().getText()));
            this.carrera_modelo.setNombre(this.carrera_vista.getTxtNombreCarrera().getText());
            this.carrera_modelo.setDuracion(Long.parseLong(this.carrera_vista.getTxtDuracionCarrera().getText()));

            if (this.carrera_modelo.modificaDatos(carrera_modelo)) {
                JOptionPane.showMessageDialog(null, "Carrera modificada correctamente");

            }
            this.limpiarTabla(this.carrera_vista.getTablaCarrera());
            llenarFilas(this.carrera_vista.getTablaCarrera());
            limpiaCuadros();
            this.carrera_vista.getTxtNombreCarrera().setEditable(true);

        } else if (e.getSource().equals(this.carrera_vista.getBtnEliminarCarrera())) {//BOTON PARA ELIMINAR CARRERA

            if (this.carrera_modelo.bajaDatos(this.carrera_vista.getTablaCarrera())) {

                this.limpiarTabla(this.carrera_vista.getTablaCarrera());
                llenarFilas(this.carrera_vista.getTablaCarrera());
                JOptionPane.showMessageDialog(null, "Carrera eliminada correctamente");
                limpiaCuadros();
                this.carrera_vista.getTxtNombreCarrera().setEditable(true);
            }

        } else if (e.getSource().equals(this.carrera_vista.getBtnVolverCarrera())) {//BOTON PARA VOLVER AL MENU
            MenuVista menu_vista = new MenuVista();
            MenuControlador menu_controlador = new MenuControlador(menu_vista);
            this.carrera_vista.dispose();
        }
    }

    //Este metodo sirve para darle nombre a cada columna de la tabla
    public String[] dameColumnas() {
        String[] Columna = {"Código de Carrera", "Nombre", "Duración"};
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
        ArrayList<CarreraModelo> carreras;
        carreras = this.carrera_modelo.muestraDatos();
        this.limpiarTabla(this.carrera_vista.getTablaCarrera());
        Object datos[] = new Object[3];
        if (carreras.size() > 0) {
            for (int i = 0; i < carreras.size(); i++) {
                datos[0] = carreras.get(i).getCod_carrera();
                datos[1] = carreras.get(i).getNombre();
                datos[2] = carreras.get(i).getDuracion();

                tabla_modelo.addRow(datos);
            }
        }

        tabla.setModel(tabla_modelo);
        carreras.clear();
    }

    //Este metodo sirve para limpiar donde se ingresan los datos
    public void limpiaCuadros() {
        this.carrera_vista.getTxtCodCarrera().setText("");
        this.carrera_vista.getTxtNombreCarrera().setText("");
        this.carrera_vista.getTxtDuracionCarrera().setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == 1) {
            int fila = this.carrera_vista.getTablaCarrera().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.carrera_vista.getTxtCodCarrera().setText(String.valueOf(this.carrera_vista.getTablaCarrera().getValueAt(fila, 0)));
                this.carrera_vista.getTxtNombreCarrera().setText(String.valueOf(this.carrera_vista.getTablaCarrera().getValueAt(fila, 1)));
                this.carrera_vista.getTxtNombreCarrera().setEditable(false);
                this.carrera_vista.getTxtDuracionCarrera().setText(String.valueOf(this.carrera_vista.getTablaCarrera().getValueAt(fila, 2)));

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
