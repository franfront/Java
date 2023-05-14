package org.ffernandez.patrones.factory.producto;

import org.ffernandez.patrones.factory.PizzaProducto;

public class PizzaBsAsItaliana extends PizzaProducto {

    public PizzaBsAsItaliana() {
        super();
        this.nombre = "Pizza Italiana";
        this.masa = "Masa gruesa";
        this.salsa = "Salsa de tomate italiana con carne";
        this.ingredientes.add("Queso mozzarella");
        this.ingredientes.add("Tomates frescos");
        this.ingredientes.add("Aceitunas");
        this.ingredientes.add("Jamón");
        this.ingredientes.add("Champiñones");
    }

    @Override
    public void hornear() {
        System.out.println("Horneando por 30 minutos a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas triangulares grandes");
    }
}
