package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjStreamListToStream {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Naruto", "Uzumaki"));
        lista.add(new Usuario("Sasuke", "Uchiha"));
        lista.add(new Usuario("Sakura", "Haruno"));
        lista.add(new Usuario("Kakashi", "Hatake"));
        lista.add(new Usuario("Boruto", "Uzumaki"));

        Stream<String>  nombres =  lista.stream()
                .map(u -> u.getNombre().toUpperCase()
                        .concat(" ").concat(u.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    if(nombre.contains("UZUMAKI")) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);

        System.out.println(nombres.count());

    }
}
