package org.ffernandez.ejemplos.set;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Set<String> unicos = new TreeSet<>((a, b) -> b.compareTo(a));
        unicos.add("uno");
        unicos.add("dos");
        unicos.add("tres");
        unicos.add("cuatro");
        unicos.add("cuatro");
        unicos.add("cinco");


        System.out.println("Unicos: " + unicos);

        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());
        numeros.add(1);
        numeros.add(5);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(10);

        System.out.println("Numeros: " + numeros);


    }
}
