package org.ffernandez.patrones.factory.producto;

import org.ffernandez.patrones.factory.PizzaProducto;

public class PizzaBsAsVegetariana extends PizzaProducto {

    public PizzaBsAsVegetariana() {
        super();
        this.nombre = "Pizza vegetariana Buenos Aires";
        this.masa = "Masa integral vegana";
        this.salsa = "Salsa de tomate";
        this.ingredientes.add("Queso vegano");
        this.ingredientes.add("Tomate");
        this.ingredientes.add("Cebolla");
        this.ingredientes.add("Pimiento");
    }

    @Override
    public void hornear() {
        System.out.println("Horneando por 25 minutos a 160°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas triangulares");
    }
}
