/*
Escriba una aplicación para almacenar aleatoriamente 20 números enteros positivos pares del 1 al 100, de los cuales se desea saber:
a) su promedio aritmético
b) cuántos de los números son iguales al promedio aritmético
c) cuántos de los números son mayores que el promedio aritmético
d) cuántos de los números son menores que el promedio aritmético
 */
package Ejercicio05;

/**
 *
 * @author Bruno
 */
public class Ejercicio05 {


    public static void main(String[] args) {

        double numeros [] = new double [20];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("");
            double numRandom = Math.floor((Math.random()* 100) * 100) / 100;
            numeros[i] = numRandom;
        }
        
        muestroArreglo(numeros);
        double suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
            
        }
        
        double promedio = Math.floor((Math.random()*20)*100)/100;
        System.out.println("El promedio es: "+ promedio);
        int mayor = 0;
        int menor = 0;
        int igual = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                ++mayor;
            } else if (numeros[i]< menor){
            ++menor; }
            else{
                ++igual;
            }
        
            System.out.println("MAYOR" +mayor);
            System.out.println("MENOR" +menor);
            System.out.println("IGUAL" + igual);
              
        
        }
        
    }
    
    private static void muestroArreglo (double [] arreglos){
        
        String cadena = ", ";
        for (int i = 0; i < arreglos.length; i++) {
            if (i > 0) {
                cadena += ", ";
            }
            
            cadena+= (arreglos[i]);
        }
        System.out.println("valores: " + cadena);
        
    }
    
}
