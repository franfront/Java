package org.ffernandez.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{
    private final List<T> objetos;
    private final int maximo;

    public Camion(int maximo) {
        this.maximo = maximo;
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(T objeto) {
        if(this.objetos.size() <= this.maximo){
            this.objetos.add(objeto);
        } else{
            throw new RuntimeException("No hay mas espacio en el camion");
        }


    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
