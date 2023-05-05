package org.ffernandez.optional.ej;

import org.ffernandez.optional.ej.models.Computador;
import org.ffernandez.optional.ej.repositorio.ComputadorRepositorio;
import org.ffernandez.optional.ej.repositorio.Repositorio;

import java.util.Optional;

public class EjRepositorio {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("HP Pavilion")
            .ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No se encontró el computador")
            );



       /* Optional<Computador> pc = repositorio.filtrar("HP Pavilion");

        if (pc.isPresent()) {
            System.out.println(pc.get());
        } else {
            System.out.println("No se encontró el computador");
        }
        */


    }
}
