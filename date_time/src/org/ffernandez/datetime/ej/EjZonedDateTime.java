package org.ffernandez.datetime.ej;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjZonedDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaLocal = LocalDateTime.parse("03/08/2024 20:00",
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("Fecha local: " + fechaLocal);

       // ZoneId zona = ZoneId.of("America/Buenos_Aires");
        ZonedDateTime zoneBsAs = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-03:00"));
        System.out.println("Hora de partida en bs as " + zoneBsAs);

        //ZoneId zona2 = ZoneId.of("Europe/Madrid");
        ZonedDateTime zoneMadrid = zoneBsAs.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(8);
        System.out.println("Hora de llegada en madrid " + zoneMadrid);



        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Hora de partida bs as " + f.format(zoneBsAs));
        System.out.println("Hora de llegada madrid " + f.format(zoneMadrid));

        Set<String> Zonas = ZoneId.getAvailableZoneIds();
        for (String zona : Zonas) {
            System.out.println(zona);
        }



    }
}
