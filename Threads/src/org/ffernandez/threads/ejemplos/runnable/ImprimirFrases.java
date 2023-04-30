package org.ffernandez.threads.ejemplos.runnable;

import org.ffernandez.threads.ejemplos.SincronizacionThread;

public class ImprimirFrases implements Runnable{
    private String frase1;
    private String frase2;

    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        SincronizacionThread.imprimirFrases(frase1, frase2);
    }
}
