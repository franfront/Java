package org.ffernandez.interfaces;

import org.ffernandez.interfaces.modelo.Cliente;
import org.ffernandez.interfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        FullRepositorio repo = new ClientListRepositorio();
        repo.guardar(new Cliente("Fernando", "Fernandez"));
        repo.guardar(new Cliente("Denise", "Monges"));
        repo.guardar(new Cliente("Luis", "Perez"));
        repo.guardar(new Cliente("Mario", "Sanchez"));

        List<Cliente> clientes = repo.listar();

        clientes.forEach(System.out::println);

        System.out.println("==== Paginable ====");
        List<Cliente> paginable =  repo.listar(0, 2);
        paginable.forEach(System.out::println);

        System.out.println("==== Ordenable ====");
        List<Cliente> ordenable =  repo.listar("nombre", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("==== Editar ====");
        Cliente dActualizado = new Cliente("Denise", "Fernandez");
        dActualizado.setId(2);
        repo.editar(dActualizado);
        System.out.println(repo.porId(2));

        System.out.println("==== Eliminar ====");
        repo.eliminar(4);
        repo.listar().forEach(System.out::println);
        System.out.println("Total: " + repo.total());



    }
}
