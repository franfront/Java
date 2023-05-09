package org.ffernandez.datetime.ej;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjDuration {
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = ldt1.plusDays(4).plusHours(2).plusMinutes(10);

        Duration d1 = Duration.between(ldt1, ldt2);
        System.out.println("d1 = " + d1);
        System.out.println(d1.toHours());

    }
}
