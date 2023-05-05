package org.ffernandez.optional.ej.repositorio;

import org.ffernandez.optional.ej.models.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        dataSource.add(new Computador("HP Pavilion", "HP"));
        dataSource.add(new Computador("MacBook Pro", "Apple"));
        dataSource.add(new Computador("Aspire 5", "Acer"));
        dataSource.add(new Computador("Inspiron 15", "Dell"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream()
                .filter(computador -> computador.getNombre().contains(nombre))
                .findFirst();



        /*for (Computador computador: dataSource) {
            if (computador.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(computador);
            }
        }
        return Optional.empty();
         */
    }
}
