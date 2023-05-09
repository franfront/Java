package org.ffernandez.datetime.ej;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class EjDuration2 {
    public static void main(String[] args) throws InterruptedException {

        Instant i1 = Instant.now();

        TimeUnit.SECONDS.sleep(5);

        Instant i2 = Instant.now();

        Duration d = Duration.between(i1, i2);
        System.out.println(d);



    }
}
