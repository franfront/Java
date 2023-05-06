package org.ffernandez.optional.ej;

import org.ffernandez.optional.ej.models.Computador;
import org.ffernandez.optional.ej.repositorio.ComputadorRepositorio;
import org.ffernandez.optional.ej.repositorio.Repositorio;

import java.util.Optional;

public class EjRepositorioOrElseThrow {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();


        Computador pc = repositorio.filtrar("HP").orElseThrow(() -> new IllegalStateException("No existe el computador"));
        System.out.println("pc = " + pc);

        String archivo = "documentopdf";
        String extension = Optional.ofNullable(archivo)
                .filter(nombre -> nombre.contains("."))
                .map(nombre -> nombre.substring(nombre.lastIndexOf(".") + 1))
                .orElseThrow(() -> new IllegalStateException("No se pudo obtener la extensión del archivo"));
        System.out.println("extension = " + extension);
    }



}
