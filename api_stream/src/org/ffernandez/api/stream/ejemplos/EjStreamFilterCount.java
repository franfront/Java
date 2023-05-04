package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjStreamFilterCount {
    public static void main(String[] args) {

         long count = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Boruto Uzumaki")
                 .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                 .peek(System.out::println)
                 .count();


        System.out.println(count);









    }
}
