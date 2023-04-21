package org.ffernandez.interfaces.repositorio;

import org.ffernandez.interfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir);

}
