package EjercicioC;

import java.util.Date;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) {

        //CREAR OBJETOS
        Date d = new Date(2020 - 1900, 5, 15);
        Date d1 = new Date(2023 - 1900, 8, 2);
        Date d2 = new Date(2025 - 1900, 2, 26);

        //Sector
        Sector s1 = new Sector();
        Sector s2 = new Sector(1, "UTN-MENDOZA", "Facultad", s1);
        Sector s3 = new Sector();
        s3.setDenominacion("Laboratorio de computación");

        //Persona
        Persona p1 = new Persona("Saul", "DNI", 20456365, 1222333, "saulgoodman@gmail.com", "96021779", s2);
        Persona p2 = new Persona("Walter", "DNI", 22369852, 1365845, "heinzenberg@gmail.com", "94563218", s2);

        //Tipo de actividad
        TipoActividad ta1 = new TipoActividad(3556, "Quimica", 35);
        TipoActividad ta2 = new TipoActividad(8523, "Abogacia", 52);

        //Actividad
        Actividad a1 = new Actividad(d, d1, "Profesor", "enseñanza", ta1, p1);
        Actividad a2 = new Actividad(d, d2, "Abogado", "en estudio jurídico", ta2, p2);
        Actividad a3 = new Actividad(d, d2, "Ciencias", "elaboración de un compuesto", ta1, p1);

        //COLABORACION ENTRE CLASES
        ta1.getActividades().add(a1);
        ta1.getActividades().add(a3);

        p1.getActividades().add(a1);
        p2.getActividades().add(a2);
        p1.getActividades().add(a3);

        s2.getPersonas().add(p1);
        s2.getPersonas().add(p2);

        s2.getSectoresHijos().add(s3);

        //Metodos
        //C1
        System.out.println("Los puntos asignados a Persona 1 son: " + p1.totalPuntosAsignados());
        System.out.println("Los puntos asignados a Persona 2 son: " + p2.totalPuntosAsignados());
        //C2
        System.out.println("Los puntos asignados a Persona 1 por la actividad 3556 son: " + p1.totalPuntosAsignados(3556));
        System.out.println("Los puntos asignados a Persona 2 por la actividad 8523 son: " + p2.totalPuntosAsignados(8523));

        //C3
        System.out.println("Los puntos asignados a Persona 1 por la actividad 3556 en el año 2023 son: " + p1.totalPuntosAsignados(3556, 2023));
        System.out.println("Los puntos asignados a Persona 2 por la actividad 8523 en el año 2024 son: " + p2.totalPuntosAsignados(8523, 2023));

        //C4
        System.out.println("Sectores: ");
        for (Sector sector : s2.obtenerTotalSubsectores()) {
            System.out.println("Los subsectores asociados a sector 2 son: " + sector.getDenominacion());
        }
    }
}
