package org.ffernandez.java.jdbc;

import org.ffernandez.java.jdbc.models.Categoria;
import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.repo.ProductoRepoImpl;
import org.ffernandez.java.jdbc.repo.Repositorio;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjJdbcUpdate {
    public static void main(String[] args) {





            Repositorio<Producto> repo = new ProductoRepoImpl();
            System.out.println("================= listar ====================");
            repo.listar().forEach(System.out::println);

            System.out.println("================= por id ====================");
            System.out.println(repo.porId(2L));

            System.out.println("================= editar ====================");
            Producto producto = new Producto();
            producto.setId(17L);
            producto.setNombre("Cafetera");
            producto.setPrecio(15000);

            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);

            repo.guardar(producto);
            repo.listar().forEach(System.out::println);
            System.out.println("Producto actualizado");





        }


    }

