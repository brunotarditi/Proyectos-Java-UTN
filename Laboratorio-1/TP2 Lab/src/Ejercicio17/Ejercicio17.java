/*
 17-Cree una clase FuncionesPrograma y codifique una función estática que reciba como parámetro 
una fecha de tipo Date y retorne la fecha como una cadena.
public static String getFechaString(Date fecha){
……….
} 
Cree una clase Principal que contenga un método main y haga uso de la función getFechaString.

 */
package Ejercicio17;

import java.util.Date;

/**
 *
 * @author Bruno
 */
public class Ejercicio17 {

   
    public static void main(String[] args) {
      
        Date fechaHoy = new Date();
        String a = FuncionesPrograma.getFechaString(fechaHoy);
        System.out.println(a);
    }
    
    
}
