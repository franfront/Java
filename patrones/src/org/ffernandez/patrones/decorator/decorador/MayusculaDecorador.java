package org.ffernandez.patrones.decorator.decorador;

import org.ffernandez.patrones.decorator.Formateable;

public class MayusculaDecorador extends TextoDecorador{


    public MayusculaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}
