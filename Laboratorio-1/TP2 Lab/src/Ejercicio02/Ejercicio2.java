/*
 Si se asigna un valor  a una variable fuera de rango (mayor de lo establecido) 
¿Qué ocurre? ¿Existe alguna forma de resolverlo? Ejemplifique.
 */
package Ejercicio02;
/**
 *
 * @author Bruno
 */
public class Ejercicio2 {


    public static void main(String[] args) {

        
        byte unByte = (byte) (int) 123456789;
        System.out.println(unByte);
       
        
     
    }
    
}

/**
 * Si se asigna un valor a una variable fuera de rango ocurre qué provoca un error de
 * compilación: incompatible types: possible lossy conversion from int to byte, ya que el valor asignado 
 * está fuera del rango permitido que posee el tipo de dato primitivo a utilizar, una excepción puede 
 * ser el casteo, y convertir el tipo de dato a uno en el que pueda almacenar mayor capacidad.
 */