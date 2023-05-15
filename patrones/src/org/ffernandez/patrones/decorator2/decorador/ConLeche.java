package org.ffernandez.patrones.decorator2.decorador;

import org.ffernandez.patrones.decorator2.Configurable;

public class ConLeche extends CafeDecorador{
    public ConLeche(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 1f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() +  " con leche";
    }
}
