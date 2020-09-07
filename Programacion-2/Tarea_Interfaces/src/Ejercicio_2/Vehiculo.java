package Ejercicio_2;

/**
 *
 * @author Bruno Tarditi
 */
//Clase vehiculo implementa la interface Asiento
public abstract class Vehiculo implements Asiento {

    //Implementa el método de manera abstracta
    @Override
    public abstract void sentarse();

}

//Tracto extiende como clase hija de Vehiculo
class Tractor extends Vehiculo {

    //Inicializa el método
    @Override
    public void sentarse() {
        System.out.println("Puedes sentarte dentro del tractor.");
    }

}

class Bicicleta extends Vehiculo {

    @Override
    public void sentarse() {
        System.out.println("Puedes sentarte en la bicicleta.");

    }

}

class Camioneta extends Vehiculo {

    String color; //Esta clase tiene un atributo

    //Constructor vacío
    public Camioneta(){
        this.color = "";
    }
    //Un constructo sobrecargado
    public Camioneta(String color) {
        this.color = color;
    }
    
    //Método get
    public String getColor() {
        return color;
    }

    //Método set
    public void setColor(String color) {
        this.color = color;
    }

    //Método sentarse inicializado
    @Override
    public void sentarse() {
        System.out.println("Puedes sentarte en la camioneta.");
    }

    

}
