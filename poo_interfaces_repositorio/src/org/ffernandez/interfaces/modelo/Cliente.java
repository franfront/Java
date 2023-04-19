package org.ffernandez.interfaces.modelo;

import java.util.Objects;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId;

    public Cliente() {
        this.id = ++ultimoId;
    }

    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // se verifica si los dos objetos son idénticos (es decir, apuntan a la misma referencia de memoria)
        if (o == null || getClass() != o.getClass()) return false; // verifica si el objeto pasado como parámetro es nulo o si el objeto actual y el pasado como parámetro son de distinto tipo
        Cliente cliente = (Cliente) o; // convierte el objeto pasado como parámetro a Cliente
        return Objects.equals(id, cliente.id); // verifica si el id del objeto actual es igual al id del objeto pasado como parámetro
    }

}
