package org.ffernandez.java.jdbc;

import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.repo.ProductoRepoImpl;
import org.ffernandez.java.jdbc.repo.Repositorio;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.sql.*;

public class EjJdbc {
    public static void main(String[] args) {




        try (Connection conn = ConexionBase.getConexion()) // Establecer conexión
        {
            Repositorio<Producto> repo = new ProductoRepoImpl();
            repo.listar().forEach(System.out::println);
            System.out.println("=====================================");
            System.out.println(repo.porId(2L));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }


    }

