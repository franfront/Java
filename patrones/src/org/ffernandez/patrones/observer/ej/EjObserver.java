package org.ffernandez.patrones.observer.ej;

import org.ffernandez.patrones.observer.Corporacion;

public class EjObserver {
    public static void main(String[] args) {
        Corporacion asdfxcv = new Corporacion("asdfxcv", 1000);
        asdfxcv.addObserver(( (obs, u) ->{
            System.out.println("El precio de " + ((Corporacion)obs).getNombre() + " ha cambiado a " + ((Corporacion)obs).getPrecio());
        }));


        asdfxcv.addObserver(( (obs,u) ->{
            System.out.println("El precio de " + ((Corporacion)obs).getNombre() + " ha cambiado a " + ((Corporacion)obs).getPrecio());
        }));

        asdfxcv.modificarPrecio(4000);
    }
}
