package org.ffernandez.ejemplo;

import org.ffernandez.pooherencia.*;

public class ejemploHerenciaConstructores {
    public static void main(String[] args) {

        System.out.println("======== Creando Alumno ============ ");
        Alumno alumno = new Alumno("Denise", "Monges", 21, "UTN");

        alumno.setNotaIngles(5.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);


        System.out.println("======== Creando Alumno Extranjero ============ ");
        AlumnoExtranjero alumnoExt = new AlumnoExtranjero("Peter","Parker", "Wakanda");

        alumnoExt.setEdad(15);
        alumnoExt.setColegio("Instituto xavier");





        System.out.println("======== Creando Profesor ============ ");
        Profesor profe = new Profesor("Franco","Fernandez", "Mate");


        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor de " + profe.getAsignatura() + ": " + profe.getNombre() + " " + profe.getApellido() );

    }
}
