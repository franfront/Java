package org.ffernandez.optional.ej;

import org.ffernandez.optional.ej.models.Computador;
import org.ffernandez.optional.ej.repositorio.ComputadorRepositorio;
import org.ffernandez.optional.ej.repositorio.Repositorio;

public class EjRepositorioOrElse {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("Dell", "Inspiron");

        Computador pc = repositorio.filtrar("rog").orElse(valorDefecto());

        System.out.println("pc = " + pc);

        pc = repositorio.filtrar("MacBook").orElseGet(EjRepositorioOrElse::valorDefecto);

        System.out.println("pc = " + pc);

    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto");
        return new Computador("Dell", "Inspiron");
    }


}
