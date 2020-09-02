/*
14-Indique cual es la diferencia entre los datos primitivos (por valor) 
ejemplo el int y su contraparte por referencia ejemplo Integer.
 */
package Ejercicio14;

/**
 *
 * @author Bruno
 */
public class Ejercicio14 {

    
    public static void main(String[] args) {
       
        int entero = 15;
        Integer entero2 = 15;

      /*La diferencia es que Integer es un tipo de dato Objeto o por referencia, mientras que el int es un 
        tipo de dato primitivo al que se le asigna un valor y se accede a ese valor directamente, incluso ya 
        tiene asignado un valor por defecto, que es el cero. Las referenciadas acceden a través de un 
        puntero, es decir, no almacenan un valor sino una dirección en la memoria, que por defecto es nulo.
        El tipo de dato int puede almacenar un número entero, mientras que Integer puede almacenar 
        diferentes variables int, y metodos para trabajar sobre dichos datos.
        */        
    }
    
}
