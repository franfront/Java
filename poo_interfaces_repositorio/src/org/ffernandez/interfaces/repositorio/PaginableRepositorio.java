package org.ffernandez.interfaces.repositorio;

import org.ffernandez.interfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
