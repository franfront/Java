package org.ffernandez.threads.ejemplos.sync;

import org.ffernandez.threads.ejemplos.sync.runnable.Cliente;
import org.ffernandez.threads.ejemplos.sync.runnable.Panadero;

public class ProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Cliente(p)).start();

    }
}
