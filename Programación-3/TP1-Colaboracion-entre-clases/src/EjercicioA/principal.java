
package EjercicioA;

/**
 *
 * @author Bruno Tarditi
 */
public class principal {
    public static void main(String[] args) {
        
        
        //NUEVOS OBJETOS
        
        Expediente ex1 = new Expediente();
        ex1.setId(1);
        ex1.setLetra("A");
        ex1.setNumero(1);
        ex1.setDescripcion("N/A");
        ex1.setTipo("Clasificado");
        ex1.setAmbito("Militar");
        
        Expediente ex2 = new Expediente();
                
        Control c1 = new Control();
        c1.setId(1);
        c1.setDenominacion("Prueba");
        c1.setEsObligatorio(true);
        
        EstadoControl ec1 = new EstadoControl();
        ec1.setId(1);
        ec1.setAprobado(true);
        
        
        ex1.getControles().add(c1);        
        c1.setEstadoControl(ec1);
        
        
        //A.1
        System.out.println(ex1.getCaratulaExpediente());
        
        //A.2
        System.out.println(ex1.getControlesObligatorio());
        
        //A.3
        
        
        //A.4
        
        
    }
}
