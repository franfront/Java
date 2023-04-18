package org.ffernandez.app.jardin;

import org.ffernandez.app.hogar.*;

import static org.ffernandez.app.hogar.Persona.*;

public class EjemploPaquetes {

    public static void main(String[] args) {
        Persona p = new Persona();

        p.setNombre("Franco");

        System.out.println(p.getNombre());



        Perro perro = new Perro();

        perro.nombre = "Polo";

        String jugando = perro.jugar(p);

        System.out.println(jugando );

        String saludo = saludar();
        System.out.println(saludo);

        String generoMujer = GENERO_FEMENINO;
        System.out.println("generoMujer = " + generoMujer);

    }




}
