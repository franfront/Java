package org.ffernandez.patrones.factory.ej;


import org.ffernandez.patrones.factory.PizzaProducto;
import org.ffernandez.patrones.factory.PizzeriaBsAsFactory;
import org.ffernandez.patrones.factory.PizzeriaCalifornia;
import org.ffernandez.patrones.factory.PizzeriaZona;

public class EjFactory {
    public static void main(String[] args) {
        PizzeriaZona bs = new PizzeriaBsAsFactory();
        PizzeriaZona ca = new PizzeriaCalifornia();

        PizzaProducto pizza = ca.ordenarPizza("queso");
        System.out.println("Bruce ordena una pizza de" + pizza.getNombre());

        pizza = bs.ordenarPizza("pepperoni");
        System.out.println("Andrés ordena una pizza de" + pizza.getNombre());

        pizza = ca.ordenarPizza("vegetariana");
        System.out.println("Linus ordena una pizza de" + pizza.getNombre());

        pizza = bs.ordenarPizza("italiana");
        System.out.println("Richard ordena una pizza de" + pizza.getNombre());

        System.out.println("pizza = " + pizza);

    }
}
