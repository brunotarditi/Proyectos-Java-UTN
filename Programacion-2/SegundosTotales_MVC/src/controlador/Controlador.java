package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author Bruno Tarditi
 */
public class Controlador implements ActionListener {

    //atributos
    private Modelo modelo;
    private Vista vista;

    public Controlador() {

    }

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        this.vista.setTitle("Convertir Segundos");
        this.vista.getBtnConvert().addActionListener(this);
        this.vista.getBtnClean().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vista.getBtnConvert())) {
            if (this.modelo.validaCampo(this.vista.getTxtDisplay().getText())) {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.");
            } else {
                this.vista.getLabelToShow().setText(this.modelo.convertSeconds(Integer.parseInt(this.vista.getTxtDisplay().getText())));

            }
        } else if (e.getSource().equals(this.vista.getBtnClean())) {
            this.vista.getTxtDisplay().setText("");
            this.vista.getLabelToShow().setText("");
        }
    }
}
