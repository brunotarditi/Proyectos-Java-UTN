/*6)- Cree las funciones necesarias para Calcular el sueldo de los trabajadores dependiendo las horas trabajadas. 
El valor de la hora en horario diurnos (8:00 a 20:00) es de $10/hora, 
si el horario es nocturno (20:00 a 8:00) se incrementa en un 50%. 
El programa debe pedir al usuario en que horario trabajo el empleado (hora ingreso, minuto ingreso, hora salida, minuto salida), 
validar que la hora/minuto de ingreso no sea mayor a la hora/minuto de salida, 
validar que la cantidad de horas trabajadas no supere las 8 horas, 
calcular cuantas horas trabajo en total y cuanto corresponde pagarle. 
Nota: Se recomienda calcular el tiempo laboral en minutos.*/
package Ejercicio6;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {

        int hora_ingreso, minuto_ingreso, hora_salida, minuto_salida, ingresoMinutos, salidaMinutos;
        double minutosTotales, sueldo = 0, totalesDiurnos, totalesNocturnos, minutosNocturnos;

        DecimalFormat formato = new DecimalFormat("#.##"); //Sirve para que si el sueldo sale con decimales, solo muestre 2 después de la coma

        //Se pide que ingresen los datos de hora de ingreso, minutos, hora de salida y mminutos
        System.out.println("Ingrese la hora de ingreso");
        hora_ingreso = new Scanner(System.in).nextInt();
        System.out.println("Ingrese los minutos de ingreso");
        minuto_ingreso = new Scanner(System.in).nextInt();
        System.out.println("Ingrese la hora de salida");
        hora_salida = new Scanner(System.in).nextInt();
        System.out.println("Ingrese los minutos de salida");
        minuto_salida = new Scanner(System.in).nextInt();

        //las horas se pasan a minutos
        ingresoMinutos = (hora_ingreso * 60) + minuto_ingreso;
        salidaMinutos = (hora_salida * 60) + minuto_salida;

        while ((salidaMinutos - ingresoMinutos) > 480 && ((salidaMinutos + 1440) - ingresoMinutos) > 480) {
            System.out.println("El empleado no puede trabajar más de 8 horas\n");
            System.out.println("Ingrese la hora de ingreso");
            hora_ingreso = new Scanner(System.in).nextInt();
            System.out.println("Ingrese los minutos de ingreso");
            minuto_ingreso = new Scanner(System.in).nextInt();
            System.out.println("Ingrese la hora de salida");
            hora_salida = new Scanner(System.in).nextInt();
            System.out.println("Ingrese los minutos de salida");
            minuto_salida = new Scanner(System.in).nextInt();

            
            ingresoMinutos = (hora_ingreso * 60) + minuto_ingreso;
            salidaMinutos = (hora_salida * 60) + minuto_salida;
        }

        //1 ingreso mayor o igual que 8 AM Y salida menor a las 20 PM Y el ingreso no debe superar a la salida
        if ((ingresoMinutos >= 480) && (salidaMinutos < 1200) && (ingresoMinutos < salidaMinutos)) {
            minutosTotales = salidaMinutos - ingresoMinutos;
            sueldo = ((minutosTotales * 10)) / 60; 

        }
        //2 ingreso mayor que 8 AM Y menor que 20 PM Y salida mayor que 20 PM y menor que 24
        if ((ingresoMinutos > 480) && (ingresoMinutos < 1200) && (salidaMinutos > 1200) && (salidaMinutos < 1440)) {
            totalesDiurnos = 1200 - ingresoMinutos;
            totalesNocturnos = salidaMinutos - 1200;
            sueldo = ((totalesDiurnos * 10) + (totalesNocturnos * 15)) / 60;

        }
        //3 ingreso mayor que 8 AM Y menor que 20 PM Y salida mayor a 0 AM Y menor a 8 AM
        if ((ingresoMinutos > 480) && (ingresoMinutos < 1200) && (salidaMinutos > 0) && (salidaMinutos < 480)) {
            totalesDiurnos = ingresoMinutos - 480;
            totalesNocturnos = 480 - salidaMinutos;
            sueldo = ((totalesDiurnos * 10) + (totalesNocturnos * 15)) / 60;

        }
        //4 ingreso mayor a 20 PM Y menor que 24 PM Y  salida mayor que 20 PM y menor que 24 PM pero el ingreso debe ser menor a la salida
        if ((ingresoMinutos > 1200) && (ingresoMinutos < 1440) && (salidaMinutos > 1200) && (salidaMinutos < 1440) && (ingresoMinutos < salidaMinutos)) {
            totalesNocturnos = salidaMinutos - ingresoMinutos;
            sueldo = (totalesNocturnos * 15) / 60;
        }
        //5 ingreso mayor que 20 PM Y menor que 24 PM Y salida mayor que 0 AM y menor que 8 AM
        if ((ingresoMinutos > 1200) && (ingresoMinutos < 1440) && (salidaMinutos > 0) && (salidaMinutos < 480)) {
            totalesNocturnos = 1440 - ingresoMinutos;
            minutosNocturnos = salidaMinutos;
            minutosTotales = totalesNocturnos + minutosNocturnos;
            sueldo = (minutosTotales * 15) / 60;
        }

        //6 ingreso mayor que 0 AM y menor que 8 AM Y salida menor que 8 AM y que el ingreso sea menor a la salida
        if ((ingresoMinutos > 0) && (ingresoMinutos < 480) && (salidaMinutos < 480) && (ingresoMinutos < salidaMinutos)) {
            totalesNocturnos = salidaMinutos - ingresoMinutos;
            minutosTotales = totalesNocturnos;
            sueldo = (minutosTotales * 15) / 60;
        }

        //7 ingreso mayor que 0 AM Y menor a 8 AM y salida mayor a 8 AM y menor que 20 PM
        if ((ingresoMinutos > 0) && (ingresoMinutos < 480) && (salidaMinutos > 480) && (salidaMinutos < 1200)) {
            totalesNocturnos = 480 - ingresoMinutos;
            totalesDiurnos = salidaMinutos - 480;
            sueldo = (totalesNocturnos * 15 + totalesDiurnos * 10) / 60;
        }

        System.out.println("El sueldo es: $" + formato.format(sueldo));

    }

}
