/*
Crea un programa que pida por pantalla cuatro países y a continuación tres
ciudades de cada uno de estos países. Los nombres de ciudades deben
almacenarse en un array multidimensional cuyo primer índice sea el número
asignado a cada país y el segundo índice el número asignado a cada ciudad. Es decir
el array deberá tener un tamaño de 4x4
 */
package Ejercicio01;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
        String [][] dosDimension = new String [5][4]; //aca definimos cantidad de filas por cantidad de columnas
        double total = 0;  
        for (int i = 0; i < dosDimension.length; i++) { //filas
            
            System.out.println("Ingrese el artículo: " + i + 1);
            String articulo = new Scanner(System.in).nextLine();
            dosDimension[i][0] = articulo;
                
            System.out.println("Ingrese el precio: " + i + 1);
            double precio = new Scanner(System.in).nextDouble();
            dosDimension[i][1] = Double.toString(precio);
            
            System.out.println("Ingrese la cantidad: " + i + 1);
            int cantidad = new Scanner(System.in).nextInt();
            dosDimension[i][2] = Integer.toString(cantidad);
        
        
            double subtotal = precio * cantidad;
            dosDimension[i][3] = Double.toString(subtotal);
        
            total+= subtotal;
        }
        
        //articulo	precio	cantidad	subtotal
        
        for (int i = 0; i < dosDimension.length; i++) { //filas
            System.out.println("");
            for (int j = 0; j < dosDimension[0].length; j++) { //columnas de cada fila
                System.out.println(dosDimension[i][j] + "\t");
            }
        }
        System.out.println("El total es: " + total);
        
    }
    
}

