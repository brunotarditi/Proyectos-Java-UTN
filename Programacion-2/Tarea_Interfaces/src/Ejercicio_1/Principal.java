package Ejercicio_1;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Objeto de la clase Galicia
        Galicia g1 = new Galicia();
        pagar(g1);
        cobrar(g1);
        depositar(g1);

        //Objeto de la clase Santander
        Santander s1 = new Santander();
        pagar(s1);
        cobrar(s1);
        depositar(s1);
        //Objeto de la clase Jumbo
        Jumbo j1 = new Jumbo();
        pagar(j1);
        cobrar(j1); //La clase hija Jumbo no tiene el método cobrar, pero lo hereda de Supermercado
        depositar(j1); //La clase hija Jumbo no tiene el método depositar, pero lo hereda de Supermercado
    }

    static void depositar(Dinero dinero) {
        dinero.depositar(0);
    }

    static void cobrar(Dinero dinero) {
        dinero.cobrar();
    }

    static void pagar(Dinero dinero) {
        dinero.pagar();
    }

}
