package org.ffernandez.java.jdbc.repo;

import org.ffernandez.java.jdbc.models.Categoria;
import org.ffernandez.java.jdbc.models.Producto;
import org.ffernandez.java.jdbc.util.ConexionBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepoImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionBase.getConnection();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try( Connection conn = getConnection();
                Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre AS categoria FROM productos AS p " + "inner join categorias AS c on (p.categoria_id = c.id)");
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
        try(    Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " + "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")){

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { // Si hay un registro
                    producto = crearProducto(rs);
                }

            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if ( producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id=? WHERE id = ?";
        } else {
            sql = "INSERT INTO productos (nombre, precio, categoria_id, fecha_registro) VALUES (?, ?, ?, ?)";
        }
        try(    Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){ // Establecer conexión
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(4, producto.getId());
            } else {
                stmt.setDate(4, new Date(producto.getFechaAlta().getTime())); // Convertir de java.util.Date a java.sql.Date

            }




            stmt.executeUpdate(); // Ejecutar la consulta
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {
        try(    Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id = ?")){
            stmt.setLong(1, id);
            stmt.executeUpdate(); // Ejecutar la consulta
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private  Producto crearProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getLong("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getInt("precio"));
        producto.setFechaAlta(rs.getDate("fecha_registro"));

        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        producto.setCategoria(categoria);


        return producto;
    }
}
