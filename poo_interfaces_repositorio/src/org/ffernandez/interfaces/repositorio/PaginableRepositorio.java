package org.ffernandez.interfaces.repositorio;

import org.ffernandez.interfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
