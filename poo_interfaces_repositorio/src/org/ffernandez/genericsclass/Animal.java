package org.ffernandez.genericsclass;

public class Animal {
    private String nombre;
    private String especie;

    public Animal(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }
}
