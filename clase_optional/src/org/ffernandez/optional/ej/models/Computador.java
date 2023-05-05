package org.ffernandez.optional.ej.models;

public class Computador {
    private String nombre;
    private String marca;


    public Computador(String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return  nombre + ", " + marca ;
    }
}
