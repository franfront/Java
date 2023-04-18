package org.franco.clasesabstractas.form.elementos.select;

public class Opcion {
    private String valor;
    private String nombre;

    private boolean seleccionada;

    public Opcion() {
    }

    public Opcion(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;

    }
    public Opcion setSeleccionada() {
        this.seleccionada = true;
        return this;

    }
}
