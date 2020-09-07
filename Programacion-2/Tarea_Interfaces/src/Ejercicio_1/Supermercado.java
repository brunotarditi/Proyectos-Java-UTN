package Ejercicio_1;

import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public abstract class Supermercado implements Dinero{
    
    //método abstracto
    @Override
    public abstract void pagar();
    
    //métodos inicializados
    @Override
    public void cobrar() {
        System.out.println("Cobrar productos.");
    }

    @Override
    public double depositar(double efectivo) {
        System.out.print("Deposite el monto al empleado: ");
        efectivo = new Scanner(System.in).nextDouble();
        System.out.println("El monto depositado es: $" + efectivo);
        
        return efectivo;
    }
}

class Jumbo extends Supermercado{
    
    //método inicializado
    @Override
    public void pagar(){
        System.out.println("Pagar compras del Jumbo.");
    }
}
