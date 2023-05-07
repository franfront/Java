package org.ffernandez.datetime.ej;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class EjLocalDate {
    public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual: " + fechaActual);
        System.out.println("Dia: " + fechaActual.getDayOfMonth());
        Month mes = fechaActual.getMonth();
        System.out.println("Mes: " +mes);
        System.out.println("Numero del mes: " + mes.getValue());
        System.out.println("Mes español: " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));


        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Numero del dia: " + diaSemana.getValue());
        System.out.println("Nombre del dia en español: " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        System.out.println("Año: " + fechaActual.getYear());
        System.out.println("Dia del año: " + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());

        fechaActual = LocalDate.of(2023, 5, 6);
        System.out.println("Fecha actual: " + fechaActual);

        fechaActual = LocalDate.of(2023, Month.MAY, 6);
        System.out.println("Fecha actual: " + fechaActual);

        fechaActual = LocalDate.parse("2023-05-06");
        System.out.println("Fecha actual: " + fechaActual);

        LocalDate diaSig = fechaActual.plusDays(1);
        System.out.println("Dia siguiente: " + diaSig);

        LocalDate mesAnt = LocalDate.now().minusMonths(1);
        System.out.println("Mes anterior: " + mesAnt);


        int diaMes = LocalDate.now().getDayOfMonth();
        System.out.println("Dia " + diaMes + " del mes");

        boolean bisiesto = LocalDate.now().isLeapYear();
        System.out.println("Año bisiesto: " + bisiesto);

        boolean esAnterior = LocalDate.now().isBefore(LocalDate.of(2020, 8, 6));
        System.out.println( "Es anterior: " + esAnterior);

        boolean esPosterior = LocalDate.now().isAfter(LocalDate.of(2021, 11, 5));
        System.out.println( "Es posterior: " + esPosterior);




    }
}
