package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjStreamParallel {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Naruto", "Uzumaki"));
        lista.add(new Usuario("Sasuke", "Uchiha"));
        lista.add(new Usuario("Sakura", "Haruno"));
        lista.add(new Usuario("Kakashi", "Hatake"));
        lista.add(new Usuario("Boruto", "Uzumaki"));

        long t1 = System.currentTimeMillis();

        String resultado =  lista.stream()
                .parallel()
                .map(u -> u.toString().toUpperCase())
                .peek(n -> {
                    System.out.println("Nombre Thread: " + Thread.currentThread().getName() + " - " + n);
                })
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(nombre.contains("HATAKE")) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("No existe");


        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2 - t1));

        System.out.println(resultado);

    }
}
