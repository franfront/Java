package org.ffernandez.interfaces.repositorio;

import org.ffernandez.interfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
   T porId(Integer id);
    void guardar(T t);
    void editar(T t);
    void eliminar(Integer id);


}
