package org.ffernandez.threads.ejemplos.executor;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjScheduledExecutorService {
    public static void main(String[] args) {

       ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main");

        executor.schedule(() ->{
            System.out.println("Alguna tarea en el executor");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }, 2, TimeUnit.SECONDS);

        System.out.println("Alguna otra tarea en el main");
        executor.shutdown();
    }
}
