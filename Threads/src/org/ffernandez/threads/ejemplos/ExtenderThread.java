package org.ffernandez.threads.ejemplos;

import org.ffernandez.threads.ejemplos.threads.NombreThread;

public class ExtenderThread {

    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Primer hilo");

        hilo.start();
        //Thread.sleep(1);

        Thread hilo2 = new NombreThread("Segundo hilo");
        hilo2.start();

        Thread hilo3 = new NombreThread("Tercer hilo");
        hilo3.start();

        System.out.println(hilo.getState());
    }

}
