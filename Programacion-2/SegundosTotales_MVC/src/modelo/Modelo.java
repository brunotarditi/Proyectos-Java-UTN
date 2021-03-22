package modelo;

/**
 *
 * @author Bruno Tarditi
 */
public class Modelo {

    private int hours;
    private int minute;
    private int second;

    public Modelo() {
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String convertSeconds(int totalSecond) {

        hours = (totalSecond / 60 / 60);
        minute = (totalSecond / 60) % 60;
        second = totalSecond % 60;

        return String.valueOf(hours) + " horas, " + String.valueOf(minute) + " minutos, " + String.valueOf(second) + " segundos.";
    }

    public boolean validaCampo(String n) {

        return n.length() == 0;
    }
}
