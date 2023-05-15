package org.ffernandez.patrones.decorator.decorador;

import org.ffernandez.patrones.decorator.Formateable;

public class SubrayadoDecorador extends TextoDecorador{
    public SubrayadoDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {

        int large = texto.darFormato().length();
        StringBuilder sb = new StringBuilder(texto.darFormato());
        sb.append("\n");
        for (int i = 0; i < large; i++) {
            sb.append("-");
        }
        return sb.toString();


    }
}
