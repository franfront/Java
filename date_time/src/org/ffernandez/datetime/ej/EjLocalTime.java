package org.ffernandez.datetime.ej;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

        boolean esAnterior = LocalTime.of(23, 20).isBefore(LocalTime.of(23, 21));
        System.out.println(esAnterior);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = ahora.format(df);
        System.out.println(horaFormateada);

        horaFormateada = df.format(ahora);
        System.out.println(horaFormateada);

        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        System.out.println(max);
        System.out.println(min);



    }
}
