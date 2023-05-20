package org.ffernandez.java.jdbc.models;

import java.util.Date;

public class Producto {
    private long id;
    private String nombre;
    private Integer precio;
    private Date fechaAlta;

    public Producto() {
    }

    public Producto(long id, String nombre, Integer precio, Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaAlta = fechaAlta;
    }

    public long getId() {
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

    @Override
    public String toString() {
        return id +
                " | " +
                nombre +
                " | " +
                precio +
                " | " +
                fechaAlta;
    }
}
