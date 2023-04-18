package org.ffernandez.interfaces.imprenta.modelo;

abstract public class Hoja {
    protected String texto;

    public Hoja(String texto) {
        this.texto = texto;
    }

    abstract public String imprimir();

}

