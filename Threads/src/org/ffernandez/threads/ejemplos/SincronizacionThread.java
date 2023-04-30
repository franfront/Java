package org.ffernandez.threads.ejemplos;

import org.ffernandez.threads.ejemplos.runnable.ImprimirFrases;

public class SincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrases("Quién ", "es él?")).start();
        new Thread(new ImprimirFrases("En que lugar ", "se enamoró de ti?")).start();

        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrases("Preguntale a que ", "dedica el tiempo libre"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());

    }

    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.println(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(frase2);
    }
}
