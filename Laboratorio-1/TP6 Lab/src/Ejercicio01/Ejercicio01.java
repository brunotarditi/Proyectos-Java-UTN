/*
 Crea un ArrayList<Integer>, asignar los valores numéricos manualmente (los que tú quieras)
hasta ingresar un valor menor a 0, mostrar los números por pantalla. Solicite los números mediante un bucle.
 */
package Ejercicio01;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Bruno
 */
public class Ejercicio01 {
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> numeros = new ArrayList();
        
        int n;
        do {
            System.out.println("Introduce números enteros, y para finalizar ingresa un valor menor a 0: ");
            n = sc.nextInt();
            if (n>=0) {
                numeros.add(n);
                
            }
        } while (n>=0);
        
        System.out.println("Ha introducido: " + numeros.size() + " numeros: ");
        System.out.print(numeros);
        
    }

}
