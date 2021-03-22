package modelo;

/**
 *
 * @author Bruno Tarditi
 */
public class Modelo {

    private String valorUno;
    private String valorDos;
    private String signo;
    
    public Modelo (){
        
    }

    public String getValorUno() {
        return valorUno;
    }

    public void setValorUno(String valorUno) {
        this.valorUno = valorUno;
    }

    public String getValorDos() {
        return valorDos;
    }

    public void setValorDos(String valorDos) {
        this.valorDos = valorDos;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    //metodo que retorna un boolean
    public boolean existePunto(String cadena) {
        //Es para saber si encuentra un punto, cuando encuentra, deja de buscar
        boolean resultado = false;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.substring(i, i + 1).equals(".")) {
                resultado = true;
                break;
            }
        }

        return resultado;
    }
    //Metodo que realiza los distintos calculos básico de la calculadora
    public String calculos(String memoria1, String memoria2, String signo) {

        double resultado = 0;
        String respuesta;

        switch (signo) {
            case "-":
                resultado = Double.parseDouble(memoria1) - Double.parseDouble(memoria2);
                break;
            case "+":
                resultado = Double.parseDouble(memoria1) + Double.parseDouble(memoria2);
                break;
            case "*":
                resultado = Double.parseDouble(memoria1) * Double.parseDouble(memoria2);
                break;
            case "/":
                resultado = Double.parseDouble(memoria1) / Double.parseDouble(memoria2);
                break;
        }

        //como retorna a un String hay que parsearlo de Double a String
        respuesta = String.valueOf(resultado);
        return respuesta;

    }
}
