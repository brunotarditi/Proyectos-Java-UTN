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
public class FuncionesPrograma {
    public static String getFechaString(Date fecha){
        String a = String.valueOf(fecha);
        
        /* valueOf: Transforma una variable
        primitiva en un String. Para
        invocarse debe usarse con
        String. Por ejemplo,
        String.valueOf(variable)*/ 
        return (a);
    }
    public static Date getFechaDate(int dia, int mes, int anio){
        Date a = new Date (anio-1900, mes-1,dia);
        return (a);
    }
}
