package org.ffernandez.ejemplos.set;

import org.ffernandez.ejemplos.modelo.Alumno;

import java.util.*;

public class ListComparableComparator {
    public static void main(String[] args) {
        //Set<Alumno> sa = new HashSet<>();
        List<Alumno> sa = new ArrayList<>();  //ArrayList no garantiza unicidad y se ordenan como se insertan
        //List<Alumno> sa = new LinkedList<>(); LinkedList no garantiza unicidad y se ordenan como se insertan
        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Pedro", 7));
        sa.add(new Alumno("Ana", 6));
        sa.add(new Alumno("Luis", 4));
        sa.add(new Alumno("Mario", 2));
        sa.add(new Alumno("Mario", 2));
        sa.add(new Alumno("Luigi", 4));
        sa.add(new Alumno("Luigi2", 8));

        //sa.sort((a, b) -> a.getNota().compareTo(b.getNota()));

        sa.sort(Comparator.comparing(Alumno::getNota).reversed());

        System.out.println("Alumnos: " + sa);



        System.out.println("Iterando con Stream y forEach");
        sa.forEach(System.out::println);


    }
}
