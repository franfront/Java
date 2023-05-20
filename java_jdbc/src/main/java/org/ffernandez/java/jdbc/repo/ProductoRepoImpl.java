package org.ffernandez.java.jdbc.repo;

import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepoImpl implements Repositorio<Producto> {

    private Connection getConnection() {
        return ConexionBase.getConexion();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
            )
        {
            while (rs.next()) {

                Producto producto = crearProducto(rs);

                productos.add(producto);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        try(PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM productos WHERE id = ?")){

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                producto = crearProducto(rs);
            }
            rs.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    private  Producto crearProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getLong("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getInt("precio"));
        producto.setFechaAlta(rs.getDate("fecha_registro"));
        return producto;
    }
}
