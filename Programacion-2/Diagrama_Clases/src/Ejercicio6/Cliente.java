package Ejercicio6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bruno Tarditi
 */
public class Cliente extends Persona implements Estado_cuenta {

    public ArrayList<Tarjeta_de_Credito> credit_Card = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(int dni, String nombre, String apellido, long cuit) {
        super(dni, nombre, apellido, cuit);
    }

    @Override
    public long getCuit() {
        return cuit;
    }

    @Override
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    @Override
    public boolean problemaVerazCodeme() {

        System.out.println("Veráz: ");
        System.out.println("1. Si");
        System.out.println("2. No");
        int o = new Scanner(System.in).nextInt();
        boolean x;

        x = o == 1;

        return x;

    }

    public ArrayList<Tarjeta_de_Credito> getCredit_Card() {
        return credit_Card;
    }

    public void setCredit_Card(ArrayList<Tarjeta_de_Credito> credit_Card) {
        this.credit_Card = credit_Card;
    }

}
