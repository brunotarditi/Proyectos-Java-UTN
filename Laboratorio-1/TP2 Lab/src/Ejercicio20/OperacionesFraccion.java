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

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class OperacionesFraccion {

    
    public static void main(String[] args) {
        
        System.out.println("Ingrese un valor entero");
        int num1 = new Scanner(System.in).nextInt();
        System.out.println("Ingrese un segundo valor entero");
        int den2 = new Scanner(System.in).nextInt();
        System.out.println("Ingrese un tercer valor entero");
        int num3 = new Scanner(System.in).nextInt();
        System.out.println("Ingrese un cuarto valor entero");
        int den4 = new Scanner(System.in).nextInt();
    
        Fraccion a = new Fraccion(num1,den2);
        Fraccion b = new Fraccion(num3,den4);
        Fraccion c = new Fraccion(1,1);
        
        c.sumarFracciones(a, b);
        System.out.println("Suma: "+ c.cadenaFraccion(c));
        c.multiplicarFracciones(a, b);
        System.out.println("Multiplicacion: " + c.cadenaFraccion(c));
        c.restarFracciones(a, b);
        System.out.println("Resta: "+ c.cadenaFraccion(c));
        c.dividirFracciones(a, b);
        System.out.println("División: " + c.cadenaFraccion(c));
        
    
    }
    
}
