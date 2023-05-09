package org.ffernandez.datetime.ej;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("fechaTiempo = " + ldt);

        ldt = LocalDateTime.of(2023, 5, 8, 21, 38, 45);
        System.out.println("fechaTiempo = " + ldt);

        ldt = LocalDateTime.parse("2023-05-08T21:38:45");
        System.out.println("fechaTiempo = " + ldt);

        ldt = ldt.plusDays(1).plusHours(4).plusMinutes(20);
        System.out.println("fechaTiempo = " + ldt.minusHours(2));

        Month mes = ldt.getMonth();
        System.out.println("mes = " + mes);

        int dia = ldt.getDayOfMonth();
        System.out.println("dia = " + dia);

        int anio = ldt.getYear();
        System.out.println("anio = " + anio);

        String formato1 = ldt.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);

        String formato2 = ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("formato2 = " + formato2);


    }
}
