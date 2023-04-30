package org.ffernandez.threads.ejemplos.sync;

import org.ffernandez.threads.ejemplos.sync.runnable.Cliente;
import org.ffernandez.threads.ejemplos.sync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class ProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                p.hornear("Pan Nº: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                p.consumir();
            };
        }).start();

    }
}
