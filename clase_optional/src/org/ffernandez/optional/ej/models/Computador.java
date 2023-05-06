package org.ffernandez.optional.ej.models;

import java.util.Optional;

public class Computador {
    private String nombre;
    private String marca;
    private Procesador procesador;


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

    public Optional<Procesador> getProcesador() {
        return Optional.ofNullable(procesador);
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return  nombre + ", " + marca ;
    }
}
