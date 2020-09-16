package orm;

import controlador.Gestor;
import java.util.Date;
import modelo.*;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        try {

            //Crear objetos
            Date d1 = new Date(2019, 5, 17);
            Date d2 = new Date(2020, 2, 2);
            Date d3 = new Date(2020, 9, 20);
            Gestor gestor = new Gestor();
            Domicilio dom1 = new Domicilio();
            Domicilio dom2 = new Domicilio();
            Especialidad e1 = new Especialidad();
            //Especialidad e2 = new Especialidad();
            Empleado emp1 = new Empleado();
            Medico m1 = new Medico();
            //Medico m2 = new Medico();
            Paciente pa1 = new Paciente();
            Turno t1 = new Turno();
            //Turno t2 = new Turno();
            HistoriaClinica hc1 = new HistoriaClinica();
            DetalleHistoriaClinica dhc1 = new DetalleHistoriaClinica();
            //DetalleHistoriaClinica dhc2 = new DetalleHistoriaClinica();

            //Colaboracion entre clases
            e1.setDenominacion("Cardiólogo");
            e1.setDenominacion("Traumatólogo");
            
            m1.setNombre("Daniel");
            m1.setApellido("López Rosetti");
            m1.setDni(16258369);
            m1.setMatricula(1236);
            m1.addEspecialidades(e1);
            m1.getTurnos().add(t1);

            dom1.setCalle("Paso de los Andes");
            dom1.setLocalidad("Godoy Cruz");
            dom1.setNumero(916);
            dom1.setPersona(m1);

            emp1.setNroLegajo(151);
            emp1.setNombre("Gustavo");
            emp1.setApellido("Fring");
            emp1.setDni(18456789);
            emp1.setSueldo(80000);

            dom2.setCalle("Emilio Civit");
            dom2.setLocalidad("Ciudad");
            dom2.setNumero(1050);
            dom2.setPersona(emp1);

            pa1.setNombre("Walter");
            pa1.setApellido("White");
            pa1.setDni(21658963);
            pa1.setNroSocio(3658);

            
            hc1.setFechaAlta(d1);
            hc1.setPaciente(pa1);
            hc1.setNumero(654);
            

            dhc1.setDiagnostico("cáncer");
            dhc1.setSintomas("tos");
            dhc1.setObservaciones("cansancio");
            dhc1.setFechaAtencion(d2);
            dhc1.setHistoriaClinica(hc1);
            
            t1.setFecha(d3);
            t1.setHora(12);
            t1.setMinutos(15);
            t1.setMedico(m1);
            t1.setPaciente(pa1);

            gestor.guardar(emp1);
            gestor.guardar(t1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
