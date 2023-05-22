package org.ffernandez.java.jdbc;

import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.repo.ProductoRepoImpl;
import org.ffernandez.java.jdbc.repo.Repositorio;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.sql.Connection;
import java.sql.SQLException;

public class EjJdbcDelete {
    public static void main(String[] args) {





            Repositorio<Producto> repo = new ProductoRepoImpl();
            System.out.println("================= listar ====================");
            repo.listar().forEach(System.out::println);

            System.out.println("================= por id ====================");
            System.out.println(repo.porId(2L));

            System.out.println("================= eliminar ====================");
            Producto producto = new Producto();
            producto.setId(3L);
            repo.eliminar(producto.getId());
            repo.listar().forEach(System.out::println);
            System.out.println("Producto eliminado");





        }


    }

