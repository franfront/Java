package org.ffernandez.threads.ejemplos.sync.runnable;

import org.ffernandez.threads.ejemplos.sync.Panaderia;

import java.lang.management.ThreadInfo;
import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            panaderia.hornear("Pan Nº: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
