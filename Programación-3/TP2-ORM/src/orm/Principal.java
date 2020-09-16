package orm;

import controlador.GestorFactura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.*;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        try {

            //Crear objetos
            Date d1 = new Date(2025, 5, 17);
            Date d2 = new Date(2022, 11, 2);

            GestorFactura gestor = new GestorFactura();

            Domicilio dom1 = new Domicilio();
            Medico m1 = new Medico();
            Especialidad e1 = new Especialidad();
            Especialidad e2 = new Especialidad();
            Empleado emp1 = new Empleado();
            Paciente pa1 = new Paciente();
            Turno t1 = new Turno();
            HistoriaClinica hc1 = new HistoriaClinica();
            DetalleHistoriaClinica dhc1 = new DetalleHistoriaClinica();
            DetalleHistoriaClinica dhc2 = new DetalleHistoriaClinica();

            List<Turno> turnos = new ArrayList<Turno>();
            List<DetalleHistoriaClinica> detalles = new ArrayList<DetalleHistoriaClinica>();
            List<Medico> medicos = new ArrayList<Medico>();
            List<Especialidad> especialidades = new ArrayList<Especialidad>();

            //Colaboracion entre clases
            //Domicilio
            dom1.setCalle("Paso de los Andes");
            dom1.setLocalidad("Godoy Cruz");
            dom1.setNumero(555);

            //Detalle Historia clinica
            dhc1.setDiagnostico("covid-19");
            dhc1.setSintomas("fiebre");
            dhc1.setObservaciones("cansancio");

            dhc2.setDiagnostico("gastritis");
            dhc2.setSintomas("vómitos");
            dhc2.setObservaciones("piel amarillenta");

            detalles.add(dhc1);
            detalles.add(dhc2);

            //Especialidad
            e1.setDenominacion("Clínico");
            e2.setDenominacion("Gastroenterólogo");

            //Paciente
            pa1.setNombre("Walter");
            pa1.setApellido("Gomez");
            pa1.setDomicilio(dom1);
            pa1.setNroSocio(0366);

            //Turnos
            t1.setFecha(d1);
            turnos.add(t1);

            //Medico
            m1.setTurnos(turnos);
            m1.setDomicilio(dom1);
            medicos.add(m1);
            especialidades.add(e1);
            especialidades.add(e2);

            pa1.setTurnos(turnos);
            pa1.setHistoriaClinica(hc1);
            hc1.setPaciente(pa1);
            hc1.setDetalles(detalles);

            e1.setMedicos(medicos);
            e2.setMedicos(medicos);
            t1.setPaciente(pa1);
            t1.setMedico(m1);
            m1.setEspecialidades(especialidades);
            emp1.setNombre("Bruno");
            emp1.setApellido("Tarditi");
            emp1.setSueldo(45000);

            gestor.guardar(m1);
            gestor.guardar(emp1);
            gestor.guardar(e1);
            gestor.guardar(e2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
