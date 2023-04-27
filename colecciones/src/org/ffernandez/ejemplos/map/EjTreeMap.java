package org.ffernandez.ejemplos.map;

import java.util.*;

public class EjTreeMap {
    public static void main(String[] args) {
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length));

        persona.put("nombre", "Saitama");
        persona.put("apellido", "Sensei");
        persona.put("edad", 35);
        persona.put("direccion", "Calle Falsa 123");


        System.out.println("==================== HashMap dentro de otro =======================");
        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "Japon");
        direccion.put("ciudad", "Ciudad Z");
        direccion.put("calle", "Calle Falsa");
        direccion.put("numero", "123");

        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);



    }
}
