package org.ffernandez.ejemplos.set;

import java.util.*;

public class EjemploHashSetA {

    public static void main(String[] args) {

        Set<String> hs = new HashSet<>();
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");

        System.out.println("Contenido del HashSet: " + hs);

        List<String> lista = new ArrayList<>(hs);
        Collections.sort(lista);
        System.out.println("Contenido del ArrayList: " + lista);

        boolean b = hs.add("uno");
        System.out.println("¿permite duplicados? " + b);
        System.out.println(hs);


    }

}
