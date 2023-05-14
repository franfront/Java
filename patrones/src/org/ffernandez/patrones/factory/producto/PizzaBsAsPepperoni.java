package org.ffernandez.patrones.factory.producto;

import org.ffernandez.patrones.factory.PizzaProducto;

public class PizzaBsAsPepperoni extends PizzaProducto {

    public PizzaBsAsPepperoni() {
        super();
        this.nombre = "Pizza Pepperoni";
        this.masa = "Masa a la piedra";
        this.salsa = "Salsa de tomate";
        this.ingredientes.add("Queso mozzarella");
        this.ingredientes.add("Extra Pepperoni");
        this.ingredientes.add("Aceitunas");


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
