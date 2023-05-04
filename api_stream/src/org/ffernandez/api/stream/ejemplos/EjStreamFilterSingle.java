package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EjStreamFilterSingle {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Boruto Uzumaki")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getApellido().equals("Uzumakix"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();


        if (usuario.isPresent()) {
            System.out.println(usuario.get().getNombre());
        }else {
            System.out.println("No se encontró el usuario");
        }

        //System.out.println(usuario.orElseGet( () -> new Usuario("John", "Doe")).getNombre());
        //System.out.println(usuario.orElse(new Usuario("John", "Doe")).getNombre());









    }
}
