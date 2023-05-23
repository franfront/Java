package org.ffernandez.java.jdbc.models;

import java.util.Date;

public class Producto {
    private long id;
    private String nombre;
    private Integer precio;
    private Date fechaAlta;

    private Categoria categoria;

    private String sku;



    public Producto() {
    }

    public Producto(long id, String nombre, Integer precio, Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaAlta = fechaAlta;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return id +
                " | " +
                nombre +
                " | " +
                precio +
                " | " +
                fechaAlta +
                " | " +
                categoria.getNombre() +
                " | " +
                sku;
    }
}
