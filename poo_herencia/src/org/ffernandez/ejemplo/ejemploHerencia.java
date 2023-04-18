package org.ffernandez.ejemplo;

import org.ffernandez.pooherencia.Alumno;
import org.ffernandez.pooherencia.AlumnoExtranjero;
import org.ffernandez.pooherencia.Profesor;

public class ejemploHerencia {
    public static void main(String[] args) {

        System.out.println("======== Creando Alumno ============ ");
        Alumno alumno = new Alumno();

        alumno.setNombre("Denise");
        alumno.setApellido("Monges");
        alumno.setColegio("UTN");
        alumno.setNotaIngles(5.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);


        System.out.println("======== Creando Alumno Extranjero ============ ");
        AlumnoExtranjero alumnoExt = new AlumnoExtranjero();
        alumnoExt.setNombre("Peter");
        alumnoExt.setApellido("Parker");
        alumnoExt.setPais("Wakanda");
        alumnoExt.setEdad(15);
        alumnoExt.setColegio("Instituto xavier");

        Class clase = alumnoExt.getClass();

       /* while (clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            clase = clase.getSuperclass();

        }*/


        System.out.println("======== Creando Profesor ============ ");
        Profesor profe = new Profesor();

        profe.setNombre("Franco");
        profe.setApellido("Fernandez");
        profe.setAsignatura("Mate");

        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor de " + profe.getAsignatura() + ": " + profe.getNombre() + " " + profe.getApellido() );

    }
}
