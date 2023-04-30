package org.ffernandez.threads.ejemplos;

import org.ffernandez.threads.ejemplos.runnable.ViajeTarea;

public class InterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

        Runnable viaje = () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.printf(i + " - " + Thread.currentThread().getName() + "\n");
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Finaliza el viaje a " + Thread.currentThread().getName());
            System.out.println("El hilo main es: " + main.getState());
        };

        Thread v1 = new Thread(viaje, "Buenos Aires");
        Thread v2 = new Thread(viaje, "Paris");
        Thread v3 = new Thread(viaje,"Madrid");
        Thread v4 = new Thread(viaje,"Londres");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join(); // Espera a que termine el hilo
        v2.join();
        v3.join();
        v4.join();


        System.out.println("Continuando con el main: " + main.getName());

    }
}
