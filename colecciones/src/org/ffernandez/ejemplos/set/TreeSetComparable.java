package org.ffernandez.ejemplos.set;

import org.ffernandez.ejemplos.modelo.Alumno;


import java.util.Set;
import java.util.TreeSet;

public class TreeSetComparable {
    public static void main(String[] args) {
        Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNota().compareTo(a.getNota()));
        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Pedro", 7));
        sa.add(new Alumno("Ana", 6));
        sa.add(new Alumno("Luis", 4));
        sa.add(new Alumno("Mario", 2));
        sa.add(new Alumno("Luigi", 2));

        System.out.println("Alumnos: " + sa);
    }
}
