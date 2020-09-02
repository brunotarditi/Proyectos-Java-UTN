/*
 15-Indique que sucede si realizo la siguiente declaración de variable:
int numero = null;
¿Qué debo modificar para poder asignar null a la variable?

 */
package Ejercicio15;

/**
 *
 * @author Bruno
 */
public class Ejercicio15 {

 
    public static void main(String[] args) {
        
        
        // int numero = null; (PRODUCE UN ERROR)
        
    /* Un tipo de dato primitivo como int no se puede declarar nula, ya que por defecto se le asigna el
       valor cero. Al declararla nulo se produce un error que puede solucionarse cambiando el tipo de dato
       primitivo int, por un tipo objeto Integer. 
       */
    
            Integer numero = null;
    }
    
}
