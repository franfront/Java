package org.ffernandez.java.jdbc;

import org.ffernandez.java.jdbc.models.Categoria;
import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.repo.ProductoRepoImpl;
import org.ffernandez.java.jdbc.repo.Repositorio;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.util.Date;

import java.sql.*;

public class EjJdbc {
    public static void main(String[] args) {




        try (Connection conn = ConexionBase.getConexion()) // Establecer conexión
        {
            Repositorio<Producto> repo = new ProductoRepoImpl();
            System.out.println("================= listar ====================");
            repo.listar().forEach(System.out::println);

            System.out.println("================= por id ====================");
            System.out.println(repo.porId(2L));

            System.out.println("================= insertar ====================");
            Producto producto = new Producto();
            producto.setNombre("Procesador Intel");
            producto.setPrecio(40000);
            producto.setFechaAlta(new Date());

            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);

            repo.guardar(producto);
            repo.listar().forEach(System.out::println);
            System.out.println("Producto guardado");





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }


    }

