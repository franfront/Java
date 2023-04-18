package org.ffernandez.interfaces.repositorio;

import org.ffernandez.interfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
    List<Cliente> listar();
    Cliente porId(Integer id);
    void guardar(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar(Integer id);


}
