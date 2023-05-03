package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Stream;

public class EjStreamFilter {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Boruto Uzumaki")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getApellido().equals("Uzumaki"))
                .peek(System.out::println);


        List<Usuario> lista = nombres.toList();
        lista.forEach(u -> System.out.println("Despues de transformar: " + u));

        //nombres.forEach(System.out::println);







    }
}
