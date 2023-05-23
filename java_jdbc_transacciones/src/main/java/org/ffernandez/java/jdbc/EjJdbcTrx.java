package org.ffernandez.java.jdbc;

import org.ffernandez.java.jdbc.models.Categoria;
import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.repo.ProductoRepoImpl;
import org.ffernandez.java.jdbc.repo.Repositorio;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjJdbcTrx {
    public static void main(String[] args) throws SQLException {




        try (Connection conn = ConexionBase.getConexion()) // Establecer conexión
        {
            if(conn.getAutoCommit()) {
                conn.setAutoCommit(false); // Deshabilitar el autocommit
            }

            try {

                Repositorio<Producto> repo = new ProductoRepoImpl();
                System.out.println("================= listar ====================");
                repo.listar().forEach(System.out::println);

                System.out.println("================= por id ====================");
                System.out.println(repo.porId(2L));

                System.out.println("================= insertar ====================");
                Producto producto = new Producto();
                producto.setNombre("motherboard Asus");
                producto.setPrecio(20000);
                producto.setFechaAlta(new Date());

                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                producto.setSku("abcde1234");
                repo.guardar(producto);

                System.out.println("Producto guardado");


                System.out.println("================= editar ====================");
                producto = new Producto();
                producto.setId(17L);
                producto.setNombre("Cafetera");
                producto.setPrecio(8000);

                categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);
                producto.setSku("abcdef1234");
                repo.guardar(producto);
                repo.listar().forEach(System.out::println);
                System.out.println("Producto actualizado");

                conn.commit(); // Commit de la transacción

            }catch (SQLException e){
                conn.rollback(); // Rollback de la transacción
                e.printStackTrace();
            }

        }

        }


    }

