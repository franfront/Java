package org.ffernandez.patrones.decorator.decorador;

import org.ffernandez.patrones.decorator.Formateable;

public abstract class TextoDecorador implements Formateable {

    protected Formateable texto;


    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
