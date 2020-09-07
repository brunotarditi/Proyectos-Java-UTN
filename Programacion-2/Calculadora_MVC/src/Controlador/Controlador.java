package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Bruno Tarditi
 */
public class Controlador implements ActionListener {

    public Vista vista;
    public Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {

        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnSuma.addActionListener(this);
        this.vista.btnResta.addActionListener(this);
        this.vista.btnMultiplicacion.addActionListener(this);
        this.vista.btnDivision.addActionListener(this);
        this.vista.btnClean.addActionListener(this);
        

    }

    public void iniciar() {

        vista.setTitle("Calculadora");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.btnSuma)) {
            vista.txtResultado.setText(modelo.operaciones("suma", vista.txtCampo1.getText(), vista.txtCampo2.getText()));
        }
        
        if (e.getSource().equals(vista.btnResta)) {
            vista.txtResultado.setText(modelo.operaciones("resta", vista.txtCampo1.getText(), vista.txtCampo2.getText()));
        }
        
        if (e.getSource().equals(vista.btnMultiplicacion)) {
            vista.txtResultado.setText(modelo.operaciones("multiplicar", vista.txtCampo1.getText(), vista.txtCampo2.getText()));
        }
        
        if (e.getSource().equals(vista.btnDivision)) {
            vista.txtResultado.setText(modelo.operaciones("dividir", vista.txtCampo1.getText(), vista.txtCampo2.getText()));
        }
        
        if (e.getSource().equals(vista.btnClean)) {
            vista.txtCampo1.setText(modelo.limpiar(vista.txtCampo1.getText()));
            vista.txtCampo2.setText(modelo.limpiar(vista.txtCampo2.getText()));
            vista.txtResultado.setText(modelo.limpiar(vista.txtResultado.getText()));
        }
 
    }
}
