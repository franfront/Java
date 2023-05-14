package org.ffernandez.patrones.factory.producto;

import org.ffernandez.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

    public PizzaCaliforniaVegetariana() {
        super();
        this.nombre = "Pizza Vegetariana California";
        this.masa = "Masa delgada";
        this.salsa = "Salsa BBQ light";
        this.ingredientes.add("Queso mozzarella");
        this.ingredientes.add("Tomates frescos");
        this.ingredientes.add("Espinacas");
        this.ingredientes.add("Berenjena");
    }

    @Override
    public void hornear() {
        System.out.println("Horneando por 20 minutos a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas");
    }
}
