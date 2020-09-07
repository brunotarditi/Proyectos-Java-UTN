package Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Clase Scanner para tomar datos por teclado
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        //Objetos instanciados
        Factura f1 = new Factura();
        Cliente c1 = new Cliente();
        Fecha fec = new Fecha();
        Producto p1 = new Producto();
        

        //Agregación de cliente, producto y fecha
        f1.getProducto().add(p1);
        f1.setCliente(c1);
        f1.setFecha(fec);
        
        

        //Datos tomados
        System.out.println("PRODUCTO");
        System.out.println("Ingrese la descripción del producto: ");
        f1.getProducto().get(0).setDescripcion(sc.nextLine());
        System.out.println("Ingrese el código del producto: ");
        f1.getProducto().get(0).setCodigo(sc.nextInt());
        System.out.println("Ingrese el precio: ");
        f1.getProducto().get(0).setPrecio(sc.nextFloat());

        System.out.println("\nCLIENTE");
        System.out.println("Ingrese Razón Social de cliente: ");
        f1.getCliente().setRazonSocial(sc1.nextLine());
        System.out.println("Ingrese código de cliente: ");
        f1.getCliente().setCodigo(sc.nextInt());

        System.out.println("\nFACTURA");
        System.out.println("Ingrese el número de factura:");
        f1.setNumero(sc.nextInt());
        System.out.println("Ingrese el tipo de factura: ");
        f1.setTipo(sc.next().charAt(0));
        System.out.println("Ingrese el total de la factura: ");
        f1.setTotal(sc.nextFloat());
        
        System.out.println("\nFECHA");
        System.out.println("Ingrese día: ");
        f1.getFecha().setDia(sc.nextInt());
        System.out.println("Ingrese mes: ");
        f1.getFecha().setMes(sc.nextInt());
        System.out.println("Ingrese año: ");
        f1.getFecha().setAnio(sc.nextInt());

        //Datos mostrados
        System.out.println("\nRazón Social de cliente: " + f1.getCliente().getRazonSocial());
        System.out.println("Código del cliente: " + f1.getCliente().getCodigo());

        System.out.println("\nNúmero de factura: " + f1.getNumero());
        System.out.println("Tipo de factura: " + f1.getTipo());
        System.out.println("Total de factura: " + f1.getTotal());

        System.out.println("\nDescripción de producto: " + f1.getProducto().get(0).getDescripcion());
        System.out.println("Código: " + f1.getProducto().get(0).getCodigo());        
        System.out.println("Precio: " + f1.getProducto().get(0).getPrecio());

        System.out.println("\n" + f1.getFecha().getDia() + "/" + f1.getFecha().getMes()+ "/" + f1.getFecha().getAnio());

    }

}
