package org.ffernandez.app.jardin;

import org.ffernandez.app.hogar.Persona;

public class Perro {
    protected String nombre;

    String jugar(Persona persona){
        return persona.lanzarPelota();
    }
}
