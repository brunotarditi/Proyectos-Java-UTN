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

            //CREAR OBJETOS
            Gestor gestor = new Gestor();
            
            //Date para las fechas
            Date d1 = new Date(2019, 5, 17);
            Date d2 = new Date(2020, 2, 2);
            Date d3 = new Date(2020, 9, 20);
            Date d4 = new Date(2020, 10, 3);
            Date d5 = new Date(2018,2,13);
            Date d6 = new Date(2019, 7, 1);
            
            Domicilio dom1 = new Domicilio();
            Domicilio dom2 = new Domicilio();
            Especialidad e1 = new Especialidad();
            Especialidad e2 = new Especialidad();
            Empleado emp1 = new Empleado();
            Medico m1 = new Medico();
            Medico m2 = new Medico();
            Paciente pa1 = new Paciente();
            Paciente pa2 = new Paciente();
            Turno t1 = new Turno();
            Turno t2 = new Turno();
            HistoriaClinica hc1 = new HistoriaClinica();
            HistoriaClinica hc2 = new HistoriaClinica();
            DetalleHistoriaClinica dhc1 = new DetalleHistoriaClinica();
            DetalleHistoriaClinica dhc2 = new DetalleHistoriaClinica();

            //Colaboracion entre clases
            //Especialidad
            //-----------> 1
            e1.setDenominacion("Cardiólogo");
            //-----------> 2
            e2.setDenominacion("Neurologo");

            //Medico -----------> 1
            m1.setNombre("Daniel");
            m1.setApellido("López Rosetti");
            m1.setDni(16258369);
            m1.setMatricula(1236);
            m1.getEspecialidades().add(e1);
            m1.getTurnos().add(t1);

            //Domicilio del medico 1
            dom1.setCalle("Paso de los Andes");
            dom1.setLocalidad("Godoy Cruz");
            dom1.setNumero(916);
            dom1.setPersona(m1);
            
            //Medico -----------> 2
            m2.setNombre("Facundo");
            m2.setApellido("Manes");
            m2.setDni(29456357);
            m2.setMatricula(2254);
            m2.getEspecialidades().add(e2);
            m2.getTurnos().add(t2);
            m2.setDomicilio(dom2);
            
            //Domicilio del medico 2
            dom1.setCalle("Bandera de los Andes");
            dom1.setLocalidad("Guaymallén");
            dom1.setNumero(1023);
            dom1.setPersona(m2);

            //Empleado -----------> 1
            emp1.setNroLegajo(151);
            emp1.setNombre("Gustavo");
            emp1.setApellido("Fring");
            emp1.setDni(18456789);
            emp1.setSueldo(80000);

            //Domicilio del empleado 
            dom2.setCalle("Emilio Civit");
            dom2.setLocalidad("Ciudad");
            dom2.setNumero(1050);
            dom2.setPersona(emp1);

            //Paciente -----------> 1
            pa1.setNombre("Walter");
            pa1.setApellido("White");
            pa1.setDni(21658963);
            pa1.setNroSocio(3658);
            
            //Paciente -----------> 2
            pa1.setNombre("Hector");
            pa1.setApellido("Salamanca");
            pa1.setDni(15555327);
            pa1.setNroSocio(2369);
            pa1.setHistoriaClinica(hc1);

            //Historia Clinica
            hc1.setFechaAlta(d1);
            hc1.setPaciente(pa1); //se asocia al paciente
            hc1.setNumero(654);
            hc1.getDetalles().add(dhc1);
            
            hc2.setFechaAlta(d5);
            hc2.setPaciente(pa2); //se asocia al paciente
            hc2.setNumero(722);
            hc2.getDetalles().add(dhc2);

            //Detalles de Historia clinica
            dhc1.setDiagnostico("cáncer");
            dhc1.setSintomas("tos");
            dhc1.setObservaciones("cansancio");
            dhc1.setFechaAtencion(d2); 
            dhc1.setHistoriaClinica(hc1);
            
            dhc2.setDiagnostico("parkinson");
            dhc2.setSintomas("temblores");
            dhc2.setObservaciones("agotamiento");
            dhc2.setFechaAtencion(d6); 
            dhc2.setHistoriaClinica(hc1); 

            //Turno para medico 1 y paciente 1
            t1.setFecha(d3);
            t1.setHora(12);
            t1.setMinutos(15);
            t1.setMedico(m1);
            t1.setPaciente(pa1);
            
            //Turno para medico 2 y paciente 2
            t2.setFecha(d4);
            t2.setHora(16);
            t2.setMinutos(50);
            t2.setMedico(m2);
            t2.setPaciente(pa2);

            gestor.guardar(t1);
            gestor.guardar(emp1);
            gestor.guardar(dhc1);
            gestor.guardar(hc1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
