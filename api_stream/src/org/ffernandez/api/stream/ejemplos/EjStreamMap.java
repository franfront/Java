package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.List;

import java.util.stream.Stream;

public class EjStreamMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Gaara Sabaku")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(u -> System.out.println("Antes de transformar: " + u))
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });


        List<Usuario> lista = nombres.toList();
        lista.forEach(u -> System.out.println("Despues de transformar: " + u));

        //nombres.forEach(System.out::println);







    }
}
