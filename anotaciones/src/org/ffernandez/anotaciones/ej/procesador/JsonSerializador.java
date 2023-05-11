package org.ffernandez.anotaciones.ej.procesador;

import org.ffernandez.anotaciones.ej.Init;
import org.ffernandez.anotaciones.ej.JsonAtributo;
import org.ffernandez.anotaciones.ej.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static void inicializarObjeto(Object o){
        if(Objects.isNull(o)) {
            throw new JsonSerializadorException("El objeto a serializar no puede ser nulo");
        }

        Method[] metodos = o.getClass().getDeclaredMethods();
        Arrays.stream(metodos)
                .filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m -> {
                    m.setAccessible(true); // Para poder acceder a los metodos privados
                    try {
                        m.invoke(o); // Invoca al metodo
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar, no se pudo inicializar el objeto" + e.getMessage());

                    }
                });

    }

    public static String convertirJson(Object o) {

        if(Objects.isNull(o)) {
            throw new JsonSerializadorException("El objeto a serializar no puede ser nulo");
        }

        inicializarObjeto(o);

        Field[] atributos = o.getClass().getDeclaredFields(); // Devuelve todos los atributos de la clase

        return Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent( JsonAtributo.class))
                .map(f -> {
                    f.setAccessible(true); // Para poder acceder a los atributos privados
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object valor = f.get(o);

                        if (f.getAnnotation(JsonAtributo.class).mayuscula() &&
                                valor instanceof String) {
                            String nuevoValor = ((String) valor);

                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0, 1).toUpperCase()
                                            + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));

                            // nuevoValor = String.valueOf(nuevoValor.charAt(0)).toUpperCase() + nuevoValor.substring(1).toLowerCase();
                            f.set(o, nuevoValor);
                        }


                        return "\"" + nombre + "\":\"" + f.get(o) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializar el json");
                    }
                } )
                .reduce("{", (a, b) -> {

                    if("{".equals(a)) {
                        return a + b;
                    }
                    return a + "," + b;

                }).concat("}");
    }
}
