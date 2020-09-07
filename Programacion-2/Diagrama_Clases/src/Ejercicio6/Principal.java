package Ejercicio6;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Scanner para tomar datos de teclado
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        //Objeto fecha
        Date d = new Date();

        //Objetos
        Cliente c1 = new Cliente();
        Tarjeta_de_Credito tc = new Tarjeta_de_Credito();
        Factura f1 = new Factura();

        //Agregación
        c1.getCredit_Card().add(tc);
        System.out.println("Ingrese el límite de la tarjeta: ");
        c1.getCredit_Card().get(0).setLimite(sc.nextDouble());

        //composición
        System.out.println("Ingrese el apellido del empleado: ");
        f1.getEmp().setNombre(sc1.nextLine());
        System.out.println("Ingrese el apellido del cliente: ");
        f1.getClie().setNombre(sc2.nextLine());
        //Set a fecha
        f1.getEmp().setFecha_Ingreso(d);

        //Mostrar datos
        System.out.println("Límite: " + c1.getCredit_Card().get(0).getLimite());
        System.out.println("Nombre de empleado: " + f1.getEmp().getNombre());
        System.out.println("Nombre del cliente: " + f1.getClie().getNombre());
        //Muestro fecha
        System.out.println(f1.getEmp().getFecha_Ingreso());

        //Interface
        System.out.println(veraz(c1));

    }

    static String veraz(Cliente x) {
        if (x.problemaVerazCodeme() == false) {
            return "No estás en el Veráz";
        } else {
            return "Estás en el Veráz";
        }
    }
}
