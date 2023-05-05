package org.ffernandez.optional.ej.repositorio;

import org.ffernandez.optional.ej.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computador> filtrar(String nombre);
}
