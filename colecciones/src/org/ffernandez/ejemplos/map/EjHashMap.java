package org.ffernandez.ejemplos.map;

import java.util.*;

public class EjHashMap {
    public static void main(String[] args) {
        Map<String, Object> persona = new HashMap<>();

        persona.put("nombre", "Saitama");
        persona.put("apellido", "Sensei");
        persona.put("edad", 35);
        persona.put("direccion", "Calle Falsa 123");
        persona.put(null, "12345");


        System.out.println("==================== HashMap dentro de otro =======================");
        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "Japon");
        direccion.put("ciudad", "Ciudad Z");
        direccion.put("calle", "Calle Falsa");
        direccion.put("numero", "123");

        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);




        System.out.println("persona = " + persona);

        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);

        Map<String, String> direccion2 = (Map<String, String>) persona.get("direccion");
        String pais = direccion2.get("pais");
        String ciudad = direccion2.get("ciudad");

        System.out.println("El pais de "+ nombre + " es " + pais);
        System.out.println("La ciudad de "+ nombre + " es " + ciudad);


        //String direccion = persona.remove("direccion");
        boolean apellido2 = persona.remove("apellido", "Sensei");
        System.out.println("direccion = " + apellido2);
        System.out.println("persona = " + persona);

        boolean b = persona.containsKey("apellido");
        System.out.println("b = " + b);

        boolean b2 = persona.containsValue("satama@sensei.com");
        System.out.println("b2 = " + b2);

        System.out.println("================  values ====================");
        Collection<Object> valores = persona.values();
        for (Object v : valores) {
            System.out.println("value = " + v);
        };

        System.out.println("================  keySet ====================");
        Set<String> llaves = persona.keySet();
        for (String llave : llaves) {
            System.out.println("key = " + llave);
        };


        System.out.println("================  entrySet ====================");
        for(Map.Entry<String, Object> par: persona.entrySet()) {
            Object value = par.getValue();
            if (value instanceof Map){
                String nombre2 = (String) persona.get("nombre");
                Map<String, String> direccion3 = (Map<String, String>) value;
                for (Map.Entry<String, String> par2: direccion3.entrySet()) {
                    System.out.println(par2.getKey() + " => " + par2.getValue()) ;
                }
            }else{
                System.out.println(par.getKey() + " => " + value);
            }

        };

        System.out.println("================  keySet ====================");
        for(String llave: persona.keySet()) {
            Object value = persona.get(llave);

            if (value instanceof Map){
                String nombre2 = (String) persona.get("nombre");
                Map<String, String> direccion3 = (Map<String, String>) value;
                System.out.println("El pais de "+ nombre2 + " es " + direccion3.get("pais"));
                System.out.println("La ciudad de "+ nombre2 + " es " + direccion3.get("ciudad"));
            }else{
            System.out.println(llave + " => " + value);
            }
        };

        System.out.println("================  java 8 forEach ====================");
        persona.forEach((key, value) -> System.out.println(key + " => " + value));


        System.out.println("total elementos: " + persona.size());
        System.out.println("contiene elementos: " + !persona.isEmpty());

        persona.replace("nombre", "Saitama", "Saitama Sensei");
        System.out.println("persona = " + persona);




    }
}
