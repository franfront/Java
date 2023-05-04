package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjStreamFilterAnyMatch {
    public static void main(String[] args) {

         boolean existe = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Boruto Uzumaki")
                 .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                 .peek(System.out::println)
                 .anyMatch(u -> u.getId().equals(1));


        System.out.println(existe);









    }
}
