package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        IntStream lengthNames = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Boruto Uzumaki")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);


        //lengthNames.forEach(System.out::println);
        IntSummaryStatistics stats = lengthNames.summaryStatistics();
        System.out.println("Suma de los caracteres de los nombres: " + stats.getSum());
        System.out.println("Promedio de los caracteres de los nombres: " + stats.getAverage());
        System.out.println("Maximo de los caracteres de los nombres: " + stats.getMax());









    }
}
