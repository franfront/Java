package org.ffernandez.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetDuplicado {
    public static void main(String[] args) {
        String[] peces = {"corvina", "Atun", "lenguado", "pejerrey", "Atun", "lenguado"};

        Set<String> unicos = new HashSet<>();

        for (String pez : peces
        ) {
            if (!unicos.add(pez)) {
                System.out.println("Elemento duplicado: " + pez);

            }
            System.out.println(unicos.size() + " elementos: " + unicos);
        }
    }
}
