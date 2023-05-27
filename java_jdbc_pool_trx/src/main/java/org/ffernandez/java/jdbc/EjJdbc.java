package org.ffernandez.java.jdbc;

import org.ffernandez.java.jdbc.models.Categoria;
import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.repo.CategoriaRepoImpl;
import org.ffernandez.java.jdbc.repo.ProductoRepoImpl;
import org.ffernandez.java.jdbc.repo.Repositorio;
import org.ffernandez.java.jdbc.service.CatalogoService;
import org.ffernandez.java.jdbc.service.Service;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.util.Date;

import java.sql.*;

public class EjJdbc {
    public static void main(String[] args) throws SQLException {

        Service servicio = new CatalogoService();
        System.out.println("================= listar ====================");
        servicio.listar().forEach(System.out::println);


        System.out.println("================= insertar nueva categoria ====================");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminación");




        System.out.println("================= insertar ====================");
        Producto producto = new Producto();
        producto.setNombre("Velador de Luna");
        producto.setPrecio(6000);
        producto.setFechaAlta(new Date());
        producto.setSku("abcd2025");

        servicio.guardarProductoCategoria(producto, categoria);
        servicio.listar().forEach(System.out::println);
        System.out.println("Producto guardado: " + producto.getId());


    }


}

