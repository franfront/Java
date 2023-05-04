package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjStreamFilterEmpty {
    public static void main(String[] args) {

        long count = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "", "Kakashi Hatake", "")

                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();

        System.out.println("count = " + count);









    }
}
