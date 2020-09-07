/*
Codifique la clase celda con los atributos:
    int fila;
    int columna;
    String valor;
*/
package Ejercicio06;

/**
 *
 * @author Bruno
 */
public class Celda {
    int fila;
    int columna;
    String valor;
    
     public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }   

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getValor() {
        return valor;
    }     
}
