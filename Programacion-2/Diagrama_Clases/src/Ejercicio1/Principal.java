package Ejercicio1;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Clase Scanner para tomar datos por teclado
        Scanner sc = new Scanner(System.in);

        //Objetos instanciados
        ContactoTipo cti = new ContactoTipo();
        ContactoDomicilio cd = new ContactoDomicilio();
        ContactoTelefono cte = new ContactoTelefono();
        Contacto c1 = new Contacto();
        Usuario u1 = new Usuario();

        c1.addDomicilio(cd);
        c1.addTelefono(cte);
        c1.setTipo(cti);
        u1.addContacto(c1);
        

        //navegaré desde usuario hasta las distintas clases de Contacto e incluso hasta la misma clase padre que comparten
        System.out.println("USUARIO");
        System.out.println("Ingrese el nombre del nuevo usuario: ");
        u1.getContactos().get(0).setNombre(sc.nextLine());
        System.out.println("Ingrese el apellido del nuevo usuario: ");
        u1.getContactos().get(0).setApellido(sc.nextLine());
        System.out.println("Ingrese el tipo de contacto del usuario: ");
        u1.getContactos().get(0).getTipo().setDescripcion(sc.nextLine());
        System.out.println("Ingrese la descripción del domicilio del usuario: ");
        u1.getContactos().get(0).getDomicilios().get(0).setDescripcion(sc.nextLine());
        System.out.println("Ingrese el teléfono del usuario: ");
        u1.getContactos().get(0).getTelefonos().get(0).setNumero(sc.nextLine());


        //Mostrar datos obtenidos
        System.out.println("USUARIO");
        System.out.println("Nombre: " + u1.getContactos().get(0).getNombre());
        System.out.println("Apellido: " + u1.getContactos().get(0).getApellido());
        System.out.println("Tipo: " + u1.getContactos().get(0).getTipo().getDescripcion());
        System.out.println("Descripción de domicilio: " + u1.getContactos().get(0).getDomicilios().get(0).getDescripcion());
        System.out.println("Número de teléfono: " + u1.getContactos().get(0).getTelefonos().get(0).getNumero());
    }
}
