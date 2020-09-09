package EjercicioB;

import java.util.Date;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //CREAR OBJETOS
        //Regimen Horario
        RegimenHorario rh1 = new RegimenHorario();
        rh1.setId(1);
        rh1.setHoraIngreso(12);
        rh1.setMinutoIngreso(0);
        rh1.setHoraEgreso(20);
        rh1.setMinutoEgreso(0);

        //Empleado
        Empleado e1 = new Empleado("Walter White", 1234567891, "308 de Negra Arroyo Lane", "heinzenberg@gmail.com", rh1);
        Empleado e2 = new Empleado("Jessie Pinkman", 2222222, "9809 Margo Street", "jpinkman@gmail.com", rh1);

        //Asistencias
        Date d = new Date(2020 - 1900, 1, 7);
        Asistencia a1 = new Asistencia(1, "E", d, 12, 0, e1);

        Date d1 = new Date(2020 - 1900, 4, 16);
        Asistencia a2 = new Asistencia(2, "E", d1, 12, 16, e2);
        a2.setId(1);
        a2.setTipo("E");

        //COLABORACION ENTRE CLASES
        e1.setRegimenHorario(rh1);
        e1.getRegimenHorario().setEmpleado(e1);
        e1.getAsistencias().add(a1);

        e2.setRegimenHorario(rh1);
        e2.getRegimenHorario().setEmpleado(e2);
        e2.getAsistencias().add(a2);

        a1.setEmpleado(e1);
        a2.setEmpleado(e2);

        //Metodos
        //B2
        System.out.println("Asistencias: ");
        for (Asistencia asistencia : e1.getAsistenciaXMesXAnio(1, 2020)) {
            System.out.println(asistencia.getFecha());
        }
        System.out.println("");
        //B3
        System.out.println("Tardanzas: ");
        for (Tardanza tardanza : e2.getDiasConTardanza(4, 2020)) {
            System.out.println(tardanza.getFecha());
        }

    }
}
