package test;

import entidades.*;
import entidadesDAO.*;

public class Main {
    public static void main(String[] args) {
        DomicilioDAO domicilioDAO = new DomicilioDAO();
        Domicilio domicilio = new Domicilio();
        domicilio.setNombreCalle("Sarmiento");
        domicilio.setNumero(555);
        domicilioDAO.insertar(domicilio);

    }
}
