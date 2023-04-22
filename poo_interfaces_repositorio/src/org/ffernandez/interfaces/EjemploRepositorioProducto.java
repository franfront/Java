package org.ffernandez.interfaces;

import org.ffernandez.interfaces.modelo.Cliente;
import org.ffernandez.interfaces.modelo.Producto;
import org.ffernandez.interfaces.repositorio.Direccion;
import org.ffernandez.interfaces.repositorio.FullRepositorio;
import org.ffernandez.interfaces.repositorio.list.ClienteListRepositorio;
import org.ffernandez.interfaces.repositorio.list.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        FullRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.guardar(new Producto("Mesa", 20500));
        repo.guardar(new Producto("Silla", 10000));
        repo.guardar(new Producto("Monitor", 50000));
        repo.guardar(new Producto("Teclado", 8000));

        List<Producto> productos = repo.listar();

        productos.forEach(System.out::println);

        System.out.println("==== Paginable ====");
        List<Producto> paginable =  repo.listar(0, 2);
        paginable.forEach(System.out::println);

        System.out.println("==== Ordenable ====");
        List<Producto> ordenable =  repo.listar("precio", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("==== Editar ====");
        Producto pActualizado = new Producto("Silla", 20000);
        pActualizado.setId(2);
        repo.editar(pActualizado);
        System.out.println(repo.porId(2));

        System.out.println("==== Eliminar ====");
        repo.eliminar(4);
        repo.listar().forEach(System.out::println);
        System.out.println("Total: " + repo.total());



    }
}
