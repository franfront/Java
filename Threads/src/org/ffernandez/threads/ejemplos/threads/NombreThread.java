package org.ffernandez.threads.ejemplos.threads;

public class NombreThread extends Thread {

    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Hola, soy el thread " + getName());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola, soy el thread " + getName() + " y estoy en la iteración " + i);
        }

        System.out.println("Hola, soy el thread " + getName() + " y voy a finalizar");
    }
}
