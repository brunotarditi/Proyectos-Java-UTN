package EjercicioB;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //Crear los objetos
        //Empleado
        Empleado e1 = new Empleado();
        e1.setNombre("Walter White");
        e1.setCuit(1234567891);
        e1.setDomicilio("308 de Negra Arroyo Lane");
        e1.setEmail("heinzenberg@gmail.com");

        //Asistencias
        Asistencia a1 = new Asistencia();
        a1.setId(1);
        a1.setTipo("E");
        Date d = new Date(2020 - 1900, 1 , 7, 12, 0);
        a1.setFecha(d);
        //a1.setHora(a1.getFecha().getHours());
        //a1.setMinuto(a1.getFecha().getMinutes());
        
        Asistencia a2 = new Asistencia();
        a2.setId(1);
        a2.setTipo("E");
        Date d1 = new Date(2020 - 1900, 4 , 16, 12, 16);
        a2.setFecha(d1);
        a2.setHora(a2.getFecha().getHours());
        a2.setMinuto(a2.getFecha().getMinutes());

        //Regimen Horario
        RegimenHorario rh1 = new RegimenHorario();
        rh1.setId(1);
        rh1.setHoraIngreso(12);
        rh1.setMinutoIngreso(0);
        rh1.setHoraEgreso(20);
        rh1.setMinutoEgreso(0);

        //colaboración entre objetos
        e1.setRegimenHorario(rh1);
        e1.getRegimenHorario().setEmpleado(e1);
        e1.getAsistencias().add(a1);
        e1.getAsistencias().add(a2);
        
        a1.setEmpleado(e1);
                       
        //B2
        List<Asistencia> asistencias = e1.getAsistenciaXMesXAnio(1, 2020);
        System.out.println("Asistencias: ");
        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia.getFecha());
        }
        System.out.println("");
        //B3
        List<Tardanza> tardanzas = e1.getDiasConTardanza(4, 2020);
        System.out.println("Tardanzas: ");
        for (Tardanza tardanza : tardanzas) {
            System.out.println(tardanza.getFecha());
        }
        
    }
}
