package org.ffernandez.java.jdbc.repo;

import org.ffernandez.java.jdbc.models.Categoria;
import org.ffernandez.java.jdbc.models.Producto;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepoImpl implements Repositorio<Producto> {

    private Connection conn;

    public ProductoRepoImpl(Connection conn) {
        this.conn = conn;
    }

    public ProductoRepoImpl() {
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try(
                Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre AS categoria FROM productos AS p " + "inner join categorias AS c on (p.categoria_id = c.id)");
            )
        {
            while (rs.next()) {

                Producto producto = crearProducto(rs);

                productos.add(producto);
            }

        }

        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try(
                PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " + "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")){

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { // Si hay un registro
                    producto = crearProducto(rs);
                }

            }
        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;
        if ( producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id=?, sku=? WHERE id = ?";
        } else {
            sql = "INSERT INTO productos (nombre, precio, categoria_id, sku, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        }
        try(
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){ // Establecer conexión
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());
            stmt.setString(4, producto.getSku());

            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());
            } else {
                stmt.setDate(5, new Date(producto.getFechaAlta().getTime())); // Convertir de java.util.Date a java.sql.Date

            }




            stmt.executeUpdate(); // Ejecutar la consulta
            if(producto.getId() == null) { // Si es un registro nuevo
                try (ResultSet rs = stmt.getGeneratedKeys()) { // Obtenemos el ID generado
                    if (rs.next()) { // Si hay un registro
                        producto.setId(rs.getLong(1)); // Asignamos el ID generado
                    }
                }
            }


            return producto;
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id = ?")){
            stmt.setLong(1, id);
            stmt.executeUpdate(); // Ejecutar la consulta
        }

    }

    private  Producto crearProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getLong("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getInt("precio"));
        producto.setFechaAlta(rs.getDate("fecha_registro"));
        producto.setSku(rs.getString("sku"));

        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        producto.setCategoria(categoria);


        return producto;
    }
}
