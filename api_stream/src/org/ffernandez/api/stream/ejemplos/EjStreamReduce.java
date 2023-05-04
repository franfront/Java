package org.ffernandez.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjStreamReduce {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Naruto Uzumaki")
                .distinct(); // no cuenta los repetidos
        
        String resultado = nombres.reduce("Resultado: ", (a, b) -> a + ", " + b);

        System.out.println(resultado);









    }
}
