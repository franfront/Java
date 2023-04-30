package org.ffernandez.threads.ejemplos;

import org.ffernandez.threads.ejemplos.runnable.ViajeTarea;

public class InterfaceRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Buenos Aires")).start();
        new Thread(new ViajeTarea("Paris")).start();
        new Thread(new ViajeTarea("Madrid")).start();
        new Thread(new ViajeTarea("Londres")).start();

    }
}
