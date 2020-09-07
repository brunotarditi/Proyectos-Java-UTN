package Modelo;

/**
 *
 * @author Bruno Tarditi
 */
public class Modelo {

    public Modelo() {

    }

    public String operaciones(String op, String txtCampo1, String txtCampo2) {

        String txtResultado;

        try {

            if (txtCampo1.trim().length() == 0 || txtCampo1.isEmpty() || txtCampo1 == null) {
                txtResultado = "Ingrese un número en el campo uno.";
            } else if (txtCampo2.trim().length() == 0 || txtCampo2.isEmpty() || txtCampo2 == null) {
                txtResultado = "Ingrese un número en el campo dos.";
            } else {

                double a, b, result = 0;
                a = Double.parseDouble(txtCampo1);
                b = Double.parseDouble(txtCampo2);

                switch (op) {
                    case "suma":
                        result = a + b;
                        break;
                    case "resta":
                        result = a - b;
                        break;
                    case "multiplicar":
                        result = a * b;
                        break;
                    case "dividir":
                        result = a / b;
                        break;
                    default:
                        break;
                }

                if (b == 0 && op.equals("dividir")) {
                    txtResultado = "No se puede dividir por 0.";
                } else {
                    txtResultado = " " + result;
                }
            }

        } catch (Exception e) {

            txtResultado = "Debe ingresar solo números.";
            txtCampo1 = null;
            txtCampo2 = null;
        }

        return txtResultado;

    }

    public String limpiar(String r) {

        return r = "";

    }

}
