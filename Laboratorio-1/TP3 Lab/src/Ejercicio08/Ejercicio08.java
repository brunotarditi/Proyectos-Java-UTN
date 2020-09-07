/*
Solicite al usuario el ingreso de una cadena de números separadas por guiones medio, por ejemplo:
45-9-8-6-45-23-21-74-96-32-45-25
Posteriormente aplique el método SPLIT de los String de Java para convertir la cadena en un arreglo, 
y calcular la suma total de los elementos y el valor promedio calculado.
 */
package Ejercicio08;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio08 {


    public static void main(String[] args) {

        String cadena;
        System.out.println("Ingrese una cadena de números separada por guiones medios: ");
        cadena = new Scanner(System.in).nextLine();
        String[] cadenaSplit = cadena.split("-");
        
        int total = 0;
        
        for (int i = 0; i < cadenaSplit.length; i++) {
            System.out.println(cadenaSplit[i] + " , ");
            
        }
        
        for (int i = 0; i < cadenaSplit.length; i++) {
            int cadenaInt = Integer.parseInt(cadenaSplit[i]);
            total += cadenaInt;
        }
        
        int promedio = total / cadenaSplit.length;
        System.out.println("La sumatoria es: "+ total);
        System.out.println("El promedio es: "+ promedio);
        
         /*Mediante el método split de la Clase String de Java podemos generar un array a partir de una cadena.
        Split recibirá como parámetro un carácter o grupo de carácteres que usará como patrón a la hora de dividir 
        la cadena para nutrir los diversos miembros del Array.*/       
       
        
    }
    
}
