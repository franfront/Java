package org.ffernandez.patrones.factory;

import org.ffernandez.patrones.factory.producto.PizzaBsAsVegetariana;
import org.ffernandez.patrones.factory.producto.PizzaBsAsItaliana;
import org.ffernandez.patrones.factory.producto.PizzaBsAsPepperoni;

public class PizzeriaBsAsFactory extends PizzeriaZona {
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto pizza = null;
        return switch (tipo) {
            case "vegetariana" -> new PizzaBsAsVegetariana();
            case "pepperoni" -> new PizzaBsAsPepperoni();
            case "italiana" -> new PizzaBsAsItaliana();
            default -> null;
        };


    }
}
