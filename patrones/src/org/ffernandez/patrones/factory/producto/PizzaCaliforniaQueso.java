package org.ffernandez.patrones.factory.producto;

import org.ffernandez.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto{
    public PizzaCaliforniaQueso() {
        super();
        this.nombre = "Pizza California Queso";
        this.masa = "Masa delgada";
        this.salsa = "Salsa de tomate rucuka";
        this.ingredientes.add("Queso mozzarella");
        this.ingredientes.add("Queso parmesano");
        this.ingredientes.add("Queso ricotta");
        this.ingredientes.add("Queso cheddar");
    }

    @Override
    public void hornear() {
        System.out.println("Horneando por 40 minutos a 100°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas triangulares pequeñas");
    }
}
