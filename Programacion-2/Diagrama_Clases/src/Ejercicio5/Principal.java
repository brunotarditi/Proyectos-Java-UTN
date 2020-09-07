package Ejercicio5;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Tomar datos por teclado
        Scanner sc = new Scanner(System.in);

        HondaXR25 xr25 = new HondaXR25();
        Rueda r1 = new Rueda();

        xr25.getRueda().add(r1);

        System.out.println("Ingrese el tipo de rueda que lleva su XR25");
        xr25.getRueda().get(0).setTipo(sc.nextLine());

        System.out.println("Tipo de ruedas de XR25: " + xr25.getRueda().get(0).getTipo());
        System.out.println("Cantidad de ruedas de XR25: " + xr25.NRUEDAS);
        
        xr25.esquivarObstaculo(0);

    }
}
