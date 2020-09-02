/*
 18-	En la clase FuncionesPrograma codifique una función estática que reciba como parámetro 3 valores enteros, día, mes, anio  y retorne la fecha de tipo Date correspondiente.
public static Date getFechaDate(int día, int mes, int anio){
……….
} 
En la clase Principal creada en el punto anterior haga uso de la función getFechaDate.

 */
package Ejercicio18;

import Ejercicio17.FuncionesPrograma;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio18 {

    
    public static void main(String[] args) {
       
        
        System.out.println("Ingrese el día: ");
        int dia = new Scanner (System.in).nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = new Scanner (System.in).nextInt();
        System.out.println("Ingrese el año: ");
        int anio = new Scanner (System.in).nextInt();
        Date a = FuncionesPrograma.getFechaDate(dia, mes, anio);
        System.out.println("La fecha ingresada es: " + a);
        
    }
    
}
