package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjStreamDistinct {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Naruto Uzumaki")
                .distinct(); // no cuenta los repetidos

        nombres.forEach(System.out::println);










    }
}
