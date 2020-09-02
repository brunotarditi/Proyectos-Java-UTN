/*
20-Cree una clase Fracción con dos atributos numéricos enteros, numerador y denominador. 
Agregue un constructor sobrecargado (debe contener como parámetros el numerador y el denominador) 
que cree el objeto Fracción correspondiente.
Agregue a la clase los siguientes 4 métodos e implemente los mismos:
public Fraccion sumarFracciones(Fraccion f1, Fraccion f2){
……….
} 
public Fraccion restarFracciones(Fraccion f1, Fraccion f2){
……….
} 
public Fraccion multiplicarFracciones(Fraccion f1, Fraccion f2){
……….
} 
public Fraccion dividirFracciones(Fraccion f1, Fraccion f2){
……….
} 
Cree una clase OperacionesFraccion que contenga un método main donde se solicite al usuario el ingreso 
de 4 valores numéricos enteros con los cuales se crearan 2 objetos Fracción y finalizada la creación 
de los mismos se ejecutaran los 4 métodos implementados anteriormente asignando el resultado a una nueva 
variable de tipo Fracción y mostrando por pantalla el resultado de las operaciones realizadas.
 */
package Ejercicio20;

/**
 *
 * @author Bruno
 */
public class Fraccion {

    int numerador, denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public Fraccion sumarFracciones(Fraccion f1, Fraccion f2) {
        int n1 = f1.getNumerador();
        int d1 = f1.getDenominador();
        int n2 = f2.getNumerador();
        int d2 = f2.getDenominador();

        denominador = (d1 * d2);
        numerador = (n1 * d2) + (n2 * d1);
        return this;

    }

    public Fraccion restarFracciones(Fraccion f1, Fraccion f2) {
        int n1 = f1.getNumerador();
        int d1 = f1.getDenominador();
        int n2 = f2.getNumerador();
        int d2 = f2.getDenominador();

        denominador = (d1 * d2);
        numerador = (n1 * d2) - (n2 * d1);
        return this;

    }

    public Fraccion multiplicarFracciones(Fraccion f1, Fraccion f2) {

        int n1 = f1.getNumerador();
        int d1 = f1.getDenominador();
        int n2 = f2.getNumerador();
        int d2 = f2.getDenominador();

        denominador = (d1 * d2);
        numerador = (n1 * n2);
        return this;

    }

    public Fraccion dividirFracciones(Fraccion f1, Fraccion f2) {

        int n1 = f1.getNumerador();
        int d1 = f1.getDenominador();
        int n2 = f2.getNumerador();
        int d2 = f2.getDenominador();

        denominador = d1 * n2;
        numerador = d2 * n1;
        return this;

    }

    public String cadenaFraccion(Fraccion h) {
        String salida = h.getNumerador() + "/" + h.getDenominador();
        System.out.println("La fraccion es: " + salida);
        return salida;
    }

}
