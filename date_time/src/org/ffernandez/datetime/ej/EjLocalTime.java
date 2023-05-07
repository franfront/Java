package org.ffernandez.datetime.ej;


import java.time.LocalTime;

public class EjLocalTime {
    public static void main(String[] args) {

        LocalTime ahora = LocalTime.now();
        System.out.println( ahora);
        System.out.println("Hora actual = " + ahora.getHour());
        System.out.println("Minutos actuales = " + ahora.getMinute());
        System.out.println("Segundos actuales = " + ahora.getSecond());
        System.out.println("Nanosegundos actuales = " + ahora.getNano());


        LocalTime hora = LocalTime.of(23, 20, 10);
        System.out.println(hora);

        LocalTime onceVeinte = LocalTime.parse("23:20");
        System.out.println(onceVeinte);

        LocalTime onceCuarenta = LocalTime.of(23, 20).plusMinutes(20);
        System.out.println(onceCuarenta);



    }
}
