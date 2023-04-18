package org.ffernandez.interfaces.repositorio;

import org.ffernandez.interfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientListRepositorio implements CrudRepositorio,
        OrdenableRepositorio, PaginableRepositorio {

    private List<Cliente> dataSource;

    public ClientListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente cli : dataSource) {
            if (cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void guardar(Cliente cliente) {
        this.dataSource.add(cliente);

    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());

    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        this.dataSource.remove(c);

    }

    @Override
    public List<Cliente> listar(String campo, String dir) {
        return null;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return null;
    }
}
