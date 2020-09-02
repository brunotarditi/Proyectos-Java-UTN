/*
19-Cree una clase OperacionMatematica con dos atributos numéricos decimales, valor1 y valor2 y 
un atributo String de nombre operación. Cree los correspondientes métodos get/set.
Agregue a la clase los siguientes 5 métodos:
private double sumarNumeros(){
return valor1 + valor2;
}
private double restarNumeros(){
return valor1 - valor2;
}
private double multiplicarNumeros(){
return valor1 * valor2;
}
private double dividirNumeros(){
return valor1 / valor2;
}
El quinto método será el siguiente:
public double aplicarOperacion(String operacion){
…………………..
}
Cree una clase Calculo que contenga un método main, donde cree una instancia de la clase OperacionMatematica, asigne 2 valores para las variables de la instancia y ejecute la función aplicarOperacion, pasando como parámetro primero “+”, después “-”, a continuación “*” y finalmente “/”. Muestre por pantalla el resultado de las operaciones.

 */
package Ejercicio19;

import java.util.Scanner;

public class Calculo {

    public static void main(String[] args) {

        OperacionMatematica clase = new OperacionMatematica(); //instancia de objeto
        System.out.println("Ingrese el primer valor");
        double numero1 = new Scanner(System.in).nextDouble();
        clase.setValor1(numero1); //modifica el el atributo
        System.out.println("Ingrese el segundo valor");
        double numero2 = new Scanner(System.in).nextDouble();
        clase.setValor2(numero2); //modifica el el atributo

        System.out.println("Ingrese la operación a realizar: + - * / %");
        String a = new Scanner(System.in).nextLine();
        clase.setOperacion(a);

        System.out.println("El resultado de la operación:  " + clase.aplicarOperacion(a));

    }
}
