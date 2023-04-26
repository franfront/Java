package org.ffernandez.ejemplos.set;

import org.ffernandez.ejemplos.modelo.Alumno;

import java.util.*;

public class HashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> sa = new HashSet<>();
        //List<Alumno> sa = new ArrayList<>();  ArrayList no garantiza unicidad y se ordenan como se insertan
        //List<Alumno> sa = new LinkedList<>(); LinkedList no garantiza unicidad y se ordenan como se insertan
        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Pedro", 7));
        sa.add(new Alumno("Ana", 6));
        sa.add(new Alumno("Luis", 4));
        sa.add(new Alumno("Mario", 2));
        sa.add(new Alumno("Mario", 2));
        sa.add(new Alumno("Luigi", 4));

        System.out.println("Alumnos: " + sa);

       /* System.out.println("Iterando con for");
        for(int i = 0; i < sa.size(); i++) {
            Alumno a = sa.get(i); get(i) devuelve el elemento en la posición i, se usa en List
            System.out.println(a);
        }
        */

        System.out.println("Iterando con for each");
        for(Alumno a : sa) {
            System.out.println(a);
        }



        System.out.println("Iterando con while e iterator");
        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()) { // hasNext() devuelve true si hay un siguiente elemento
            Alumno a = it.next(); // next() devuelve el siguiente elemento
            System.out.println(a);
        }

        System.out.println("Iterando con Stream y forEach");
        sa.forEach(System.out::println);


    }
}
