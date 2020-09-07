package Ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Clase Scanner para tomar datos
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        //Objetos
        Mafioso m1 = new Mafioso();
        Detective d1 = new Detective();
        Perfil pr1 = new Perfil();
        Lugar l1 = new Lugar();
        MedioDeComuniacion mc = new MedioDeComuniacion();

        System.out.println("PERSONA");
        m1.agregarPerfil(pr1);
        m1.getComunicaciones().add(mc);
        System.out.println("Ingrese el tipo de perfil de la persona: ");
        m1.getPerfiles().get(0).setTipoPerfil(sc.nextInt());
        System.out.println("Descripción del medio: ");
        m1.getComunicaciones().get(0).setDescripcion(sc1.nextLine());
        
        System.out.println(d1.investigarMafioso(m1));
        

        System.out.println("MAFIOSO");
        m1.agregarLugar(l1);
        System.out.println("Nombre del lugar: ");
        m1.getLugaresFrecuentes().get(0).setNombre(sc1.nextLine());

        //Muestro datos
        System.out.println("Perfil: " + m1.getPerfiles().get(0).getTipoPerfil());
        System.out.println("Lugar: " + m1.getLugaresFrecuentes().get(0).getNombre());
        System.out.println("Descripción del medio: " + m1.getComunicaciones().get(0).getDescripcion());

    }
}
