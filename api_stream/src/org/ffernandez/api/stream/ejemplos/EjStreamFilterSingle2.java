package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjStreamFilterSingle2 {
    public static void main(String[] args) {

         Usuario usuario = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Boruto Uzumaki")
                 .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                 .peek(System.out::println)
                 .filter(u -> u.getId().equals(8))
                 .findFirst().orElseGet(() -> new Usuario("John", "Doe"));


        System.out.println(usuario);









    }
}
