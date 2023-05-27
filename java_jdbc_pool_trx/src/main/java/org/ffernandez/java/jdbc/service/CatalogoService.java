package org.ffernandez.java.jdbc.service;

import org.ffernandez.java.jdbc.models.Categoria;
import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.repo.CategoriaRepoImpl;
import org.ffernandez.java.jdbc.repo.ProductoRepoImpl;
import org.ffernandez.java.jdbc.repo.Repositorio;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoService implements Service {
    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoService() {
        this.productoRepositorio = new ProductoRepoImpl();
        this.categoriaRepositorio = new CategoriaRepoImpl();
    }

    @Override
    public List<Producto> listar() throws SQLException {

        try(Connection conn = ConexionBase.getConnection()){
            productoRepositorio.setConn(conn);
            return productoRepositorio.listar();
        }


    }

    @Override
    public Producto porId(Long id) throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            productoRepositorio.setConn(conn);
            return productoRepositorio.porId(id);
        }

    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            productoRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            Producto nuevoProducto = null;
            try{
                nuevoProducto = productoRepositorio.guardar(producto);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
            }
            return nuevoProducto;
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            productoRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                productoRepositorio.eliminar(id);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
            }
        }

    }

    @Override
    public List<Categoria> listarCategorias() throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.listar();
        }
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.porId(id);
        }

    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            categoriaRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try{
                nuevaCategoria = categoriaRepositorio.guardar(categoria);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
            }
            return nuevaCategoria;
        }

    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            categoriaRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                categoriaRepositorio.eliminar(id);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
            }
        }

    }

    @Override
    public void guardarProductoCategoria(Producto producto, Categoria categoria) throws SQLException {
        try(Connection conn = ConexionBase.getConnection()){
            productoRepositorio.setConn(conn);
            categoriaRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                Categoria nuevaCategoria = categoriaRepositorio.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                productoRepositorio.guardar(producto);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }


    }
}
