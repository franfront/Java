package org.ffernandez.threads.ejemplos.runnable;

public class ViajeTarea implements Runnable {

    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf(i + " - " + nombre + "\n");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finaliza el viaje a " + nombre);

    }
}
