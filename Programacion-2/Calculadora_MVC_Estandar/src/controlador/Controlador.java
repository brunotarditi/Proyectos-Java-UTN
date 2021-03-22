package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    //Constructor vacío
    public Controlador() {

    }

    public Controlador(Vista vista, Modelo modelo) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Calculadora");
        botones_en_escucha();
    }

    //Con este metodo se ponen los botones a la escucha
    public void botones_en_escucha() {
        this.vista.btn_cero.addActionListener(this);
        this.vista.btn_uno.addActionListener(this);
        this.vista.btn_dos.addActionListener(this);
        this.vista.btn_tres.addActionListener(this);
        this.vista.btn_cuatro.addActionListener(this);
        this.vista.btn_cinco.addActionListener(this);
        this.vista.btn_seis.addActionListener(this);
        this.vista.btn_siete.addActionListener(this);
        this.vista.btn_ocho.addActionListener(this);
        this.vista.btn_nueve.addActionListener(this);
        this.vista.btn_dividir.addActionListener(this);
        this.vista.btn_multiplicacion.addActionListener(this);
        this.vista.btn_menos.addActionListener(this);
        this.vista.btn_suma.addActionListener(this);
        this.vista.btn_c.addActionListener(this);
        this.vista.btn_ce.addActionListener(this);
        this.vista.btn_igual.addActionListener(this);
        this.vista.btn_uno_x.addActionListener(this);
        this.vista.btn_mas_menos.addActionListener(this);
        this.vista.btn_punto.addActionListener(this);

    }

    //Se implementa el metodo de la interface
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vista.btn_uno)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "1");
        } else if (e.getSource().equals(this.vista.btn_dos)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "2");
        } else if (e.getSource().equals(this.vista.btn_tres)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "3");
        } else if (e.getSource().equals(this.vista.btn_cuatro)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "4");
        } else if (e.getSource().equals(this.vista.btn_cinco)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "5");
        } else if (e.getSource().equals(this.vista.btn_seis)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "6");
        } else if (e.getSource().equals(this.vista.btn_siete)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "7");
        } else if (e.getSource().equals(this.vista.btn_ocho)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "8");
        } else if (e.getSource().equals(this.vista.btn_nueve)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "9");
        } else if (e.getSource().equals(this.vista.btn_cero)) {
            vista.txtpantalla.setText(vista.txtpantalla.getText() + "0");
        } else if (e.getSource().equals(this.vista.btn_punto)) {
            // Se declara esta variable para guardar todo lo que tengo en la pantalla
            String cadena = vista.txtpantalla.getText(); 
            // si es menor o igual que 0 quiere decir que la cadena está vacía
            if (cadena.length() <= 0) { 
                vista.txtpantalla.setText("0.");
            } else {
                if (!modelo.existePunto(vista.txtpantalla.getText())) {
                    vista.txtpantalla.setText(vista.txtpantalla.getText() + ".");
                }
            }
        } else if (e.getSource().equals(this.vista.btn_menos)) {
            //si la pantalla no está en blanco
            if (!vista.txtpantalla.getText().equals("")) { 
                modelo.setValorUno(vista.txtpantalla.getText());
                modelo.setSigno("-");
                //se deja la pantalla en blanco para seguir escribir otro valor
                vista.txtpantalla.setText("");

            }
        } else if (e.getSource().equals(this.vista.btn_suma)) {
            //si la pantalla no está en blanco
            if (!vista.txtpantalla.getText().equals("")) { 
                modelo.setValorUno(vista.txtpantalla.getText());
                modelo.setSigno("+");
                //se deja la pantalla en blanco para seguir escribir otro valor
                vista.txtpantalla.setText("");

            }
        } else if (e.getSource().equals(this.vista.btn_multiplicacion)) {
            //si la pantalla no está en blanco
            if (!vista.txtpantalla.getText().equals("")) { 
                modelo.setValorUno(vista.txtpantalla.getText());
                modelo.setSigno("*");
                //se deja la pantalla en blanco para seguir escribir otro valor
                vista.txtpantalla.setText("");

            }
        } else if (e.getSource().equals(this.vista.btn_dividir)) {
            //si la pantalla no está en blanco
            if (!vista.txtpantalla.getText().equals("")) { 
                modelo.setValorUno(vista.txtpantalla.getText());
                modelo.setSigno("/");
                //se deja la pantalla en blanco para seguir escribir otro valor
                vista.txtpantalla.setText("");

            }
        } else if (e.getSource().equals(this.vista.btn_igual)) {
            String resultado;
            //va a ser igual a lo que tiene actualmente la pantalla
            modelo.setValorDos(vista.txtpantalla.getText());
            //si memoria2 no está en blanco
            if (!modelo.getValorDos().equals("")) { 
                //va a ser igual al metodo para calcular con los distintos operadores
                resultado = modelo.calculos(modelo.getValorUno(), modelo.getValorDos(), modelo.getSigno()); 
                //se muestra el resultado final
                vista.txtpantalla.setText(resultado); 
            }
        } else if (e.getSource().equals(this.vista.btn_c)) {
            //Se limpiar toda la pantalla
            vista.txtpantalla.setText("");
        } else if (e.getSource().equals(this.vista.btn_ce)) {
            String cadena = vista.txtpantalla.getText();
            // si es mayor a 0 es porque NO está vacía
            if (cadena.length() > 0) { 
                cadena = cadena.substring(0, cadena.length() - 1);
                /**
                 * la cadena va a ser igual a lo que tiene la cadena, osea 0,
                 * hasta lo que tenga - 1, es decir, si tiene 5 caracteres, y se
                 * resta 1, va a tener 4, porque es el boton de borrar caracter*
                 */
                vista.txtpantalla.setText(cadena);
            }
        } else if (e.getSource().equals(this.vista.btn_mas_menos)) {
            double numero;
            String cadena = vista.txtpantalla.getText();
            if (cadena.length() > 0) {
                //para convertir un numero negativo a positivo, debo multiplicar por un valor negativo, por ejemplo, -1
                numero = (-1) * Double.parseDouble(cadena);
                vista.txtpantalla.setText(String.valueOf(numero));
            }
        } else if (e.getSource().equals(this.vista.btn_uno_x)) {
            //boton de 1/x
            String cadena = vista.txtpantalla.getText();
            double numero;
            if (cadena.length() > 0) {
                numero = 1 / Double.parseDouble(cadena);
                vista.txtpantalla.setText(String.valueOf(numero));
            }
        }
    }
}
