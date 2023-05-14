package org.ffernandez.patrones.factory;

public abstract class PizzeriaZona {
    public PizzaProducto ordenarPizza(String tipo){
        PizzaProducto pizza = crearPizza(tipo);
        System.out.println("---- Preparando " + pizza.getNombre() + " ----");
        pizza.preparar();
        pizza.hornear();
        pizza.cortar();
        pizza.empacar();
        return pizza;

    }


    abstract PizzaProducto crearPizza(String tipo);


}
