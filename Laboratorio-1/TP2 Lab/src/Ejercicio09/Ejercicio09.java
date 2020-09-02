/*
 9-Recorre el String del ejercicio 6 y transforma cada carácter a su código ASCII. 
Muéstralos en línea recta, separados por un espacio entre cada carácter.
 */
package Ejercicio09;
/**
 *
 * @author Bruno
 */
public class Ejercicio09 {

    
    public static void main(String[] args) {
      
        String cadena = "La lluvia en Mendoza es escasa";
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println(cadena.charAt(i) + " = " + cadena.codePointAt(i));
            
        }
        
    }
    
}
