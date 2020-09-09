package EjercicioD;

/**
 *
 * @author Bruno Tarditi
 */
public class Principal {

    public static void main(String[] args) throws Exception {

        //CREAR OBJETOS
        //Barrio
        Barrio b1 = new Barrio(45523, "Sanidad", "Construcciones Civiles");

        //Vivienda
        Vivienda v1 = new Vivienda(20596, "Gainza", 3071, 250, b1);
        Vivienda v2 = new Vivienda(50489, "Carrillo", 3175, 280, b1);

        //Habitación
        Habitacion h1 = new Habitacion(10, "Baño", 15, v1);
        Habitacion h2 = new Habitacion(15, "Cocina", 40, v2);

        //COLABORACION ENTRE CLASES
        b1.getViviendas().add(v1);
        b1.getViviendas().add(v2);
        v1.getHabitaciones().add(h1);
        v2.getHabitaciones().add(h2);

        //Metodos
        //D1
        System.out.println("La superficie total del barrio es: " + b1.getSuperficieTotalTerreno());

        //D2
        System.out.println("Los m2 cubiertos de la vivienda 1 son: " + v1.getMetrosCuadradosCubiertos());
        System.out.println("Los m2 cubiertos de la vivienda 2 son: " + v2.getMetrosCuadradosCubiertos());

        //D3
        System.out.println("La superficie cubierta del barrio es: " + b1.getSuperficieTotalCubierta());

    }
}
