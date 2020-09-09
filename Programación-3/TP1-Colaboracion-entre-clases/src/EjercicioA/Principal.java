package EjercicioA;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //CREAR LOS OBJETOS
        //Expediente
        Expediente e1 = new Expediente();
        e1.setId(0);
        e1.setLetra("C");
        e1.setNumero(2589);
        e1.setDescripcion("firma de contrato");
        e1.setAmbito("Laboral");
        e1.setTipo("Contractual");

        Expediente e2 = new Expediente(1, "A", 1234, "legajo", "Educativo", "Escolar", e1);
        Expediente e3 = new Expediente();
        e3.setId(2);
        Expediente e4 = new Expediente(3, "B", 4567, "compra de materiales", "Financiero", "Contable", e3);
        Expediente e5 = new Expediente();
        e5.setId(4);

        //Estado Control
        EstadoControl ec1 = new EstadoControl(1, true);
        EstadoControl ec2 = new EstadoControl(2, false);
        EstadoControl ec3 = new EstadoControl(3, true);

        //Control
        Control c1 = new Control(1, "Control 1", true, ec1);
        Control c2 = new Control(2, "Control 2", false, ec2);
        Control c3 = new Control(3, "Control 3", true, ec3);

        //COLABORACION DE CLASES
        e1.getControles().add(c1);
        e1.getControles().add(c2);
        e1.setExpedientePadre(e3);
        e1.getExpedientesHijos().add(e5);

        e2.getControles().add(c1);
        e2.getControles().add(c2);

        e3.getControles().add(c3);

        e4.getControles().add(c1);
        e4.setExpedientePadre(e2);
        e4.getExpedientesHijos().add(e5);

        c1.setEstadoControl(ec1);
        c1.setEstadoControl(ec2);
        c2.setEstadoControl(ec3);
        c3.setEstadoControl(ec3);

        //Metodos
        //A.1
        System.out.println(e1.getCaratulaExpediente());
        System.out.println(e2.getCaratulaExpediente());
        System.out.println(e4.getCaratulaExpediente());

        //A.2
        System.out.print(e2.getControlesObligatorio());
        System.out.println(e4.getControlesObligatorio());

        //A.3
        System.out.println(e1.getEstadoControles());
        System.out.println(e2.getEstadoControles());
        System.out.println(e4.getEstadoControles());

        //A.4
        System.out.print("Los expedientes asociados al expediente 2 son: ");
        for (Expediente expediente : e2.listaExpedientes()) {
            System.out.println(expediente.getCaratulaExpediente() + " ");
        }

    }
}
