package org.ffernandez.anotaciones.ej;

import org.ffernandez.anotaciones.ej.models.Producto;
import org.ffernandez.anotaciones.ej.procesador.JsonSerializador;

import java.time.LocalDate;


public class EjAnotacion {
    public static void main(String[] args) {



        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("procesador intel de onceava generacion");
        p.setPrecio(1000L);



        System.out.println("json = " + JsonSerializador.convertirJson(p));


    }
}
