package org.ffernandez.threads.ejemplos.sync;

public class Panaderia {
    private String pan;
    private boolean disponible;
    public synchronized void hornear(String masa) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.pan = masa;
        System.out.println("El panadero ha terminado de hornear el pan: " + this.pan);
        this.disponible = true;
        notify();
    }

    public synchronized String consumir() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El cliente se ha comido el pan: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}
