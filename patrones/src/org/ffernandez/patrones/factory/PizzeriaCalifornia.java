package org.ffernandez.patrones.factory;

import org.ffernandez.patrones.factory.producto.PizzaCaliforniaPepperoni;
import org.ffernandez.patrones.factory.producto.PizzaCaliforniaQueso;
import org.ffernandez.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCalifornia extends PizzeriaZona{
    @Override
    PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "queso" -> new PizzaCaliforniaQueso();
            case "pepperoni" -> new PizzaCaliforniaPepperoni();
            case "vegetariana" -> new PizzaCaliforniaVegetariana();
            default -> null;
        };
    }
}
