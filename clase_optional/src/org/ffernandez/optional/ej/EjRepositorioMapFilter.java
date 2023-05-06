package org.ffernandez.optional.ej;

import org.ffernandez.optional.ej.models.Computador;
import org.ffernandez.optional.ej.models.Fabricante;
import org.ffernandez.optional.ej.models.Procesador;
import org.ffernandez.optional.ej.repositorio.ComputadorRepositorio;
import org.ffernandez.optional.ej.repositorio.Repositorio;

public class EjRepositorioMapFilter {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("Dell", "Inspiron");

        String f = repositorio.filtrar("Aspire")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(fabricante -> "Intel".equalsIgnoreCase(fabricante.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");

        System.out.println(f);



    }




}
