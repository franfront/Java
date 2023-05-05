package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Stream;

public class EjStreamFlatMap {
    public static void main(String[] args) {


        Stream<Usuario> nombres = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Boruto Uzumaki")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .flatMap(u -> {
                    if(u.getApellido().equalsIgnoreCase("Uzumaki")) { // si el nombre es naruto
                        return Stream.of(u); // retorna un stream con un solo elemento
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);


        //nombres.forEach(System.out::println);
        System.out.println(nombres.count());






    }
}
