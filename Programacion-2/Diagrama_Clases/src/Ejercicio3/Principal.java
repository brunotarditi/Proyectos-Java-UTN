package Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {
    public static void main(String[] args) {
        
        //Tomo datos por teclado
        Scanner sc = new Scanner(System.in);
        
        //Creo Recibo que es hijo de comprobante y con eso ya podré navegar al resto de clases
        Recibo r1 = new Recibo();
        
        //Navegabilidad
        System.out.println("RECIBO");
        System.out.println("Ingrese razón social: ");
        r1.getProveedor().setRazonSocial(sc.nextLine());
        System.out.println("Ingrese código de recibo: ");
        r1.getProveedor().setCodigo(sc.nextInt());
        System.out.println("Ingrese el día: ");
        r1.getFecha().setDia(sc.nextInt());
        System.out.println("Ingrese el mes: ");
        r1.getFecha().setMes(sc.nextInt());
        System.out.println("Ingrese año: ");
        r1.getFecha().setAnio(sc.nextInt());
        
        
        //Muestro datos
        System.out.println("Razón Social: " + r1.getProveedor().getRazonSocial());
        System.out.println("Código: " + r1.getProveedor().getCodigo());
        System.out.println(r1.getFecha().getDia() + "/" + r1.getFecha().getMes() + "/" + r1.getFecha().getAnio());
    }
}
