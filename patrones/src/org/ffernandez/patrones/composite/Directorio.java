package org.ffernandez.patrones.composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente {

    private List<Componente> hijos;


    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    public Directorio add(Componente c) {
        this.hijos.add(c);
        return this;
    }

    ;

    public void remove(Componente c) {
        this.hijos.remove(c);
    }

    ;

    @Override
    public String mostrar(int nivel) {
        StringBuilder sb = new StringBuilder("\t".repeat(nivel));
        sb.append(nombre).append("/").append("\n");
        for (Componente c : hijos) {
            sb.append(c.mostrar(nivel + 1));
            if (c instanceof Archivo) {
                sb.append("\n");
            }

        }
        return sb.toString();
    }

    @Override
    public boolean buscar(String nombre) {
        if (this.nombre.equals(nombre)) {
            return true;
        }




        /*for (Componente c : hijos) {
            if (c.buscar(nombre)) {
                return true;

            }

        }
         */
        return hijos.stream().anyMatch(h -> h.buscar(nombre));


    }

}