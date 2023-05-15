package org.ffernandez.patrones.decorator2;

import org.ffernandez.patrones.decorator2.decorador.ConCremaDecorador;
import org.ffernandez.patrones.decorator2.decorador.ConLeche;

public class EjDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe(10f, "Cafe Mocha");
        ConCremaDecorador cafeConCrema = new ConCremaDecorador(cafe);
        ConLeche cafeConLeche = new ConLeche(cafeConCrema);
        System.out.println("Ingredientes del cafe mocha: " + cafeConLeche.getIngredientes());
        System.out.println("Precio del cafe mocha: " + cafeConLeche.getPrecioBase());

        Configurable cafe2 = new Cafe(8f, "Cafe Capuchino");
        cafeConCrema = new ConCremaDecorador(cafe2);
        cafeConLeche = new ConLeche(cafeConCrema);
        System.out.println("Ingredientes del capuchino: " + cafeConLeche.getIngredientes());
        System.out.println("Precio del capuchino: " + cafeConLeche.getPrecioBase());


    }
}
