package org.ffernandez.ejemplos.list;

import org.ffernandez.ejemplos.modelo.Alumno;


import java.util.LinkedList;
import java.util.ListIterator;

public class EjLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> enlazada = new LinkedList<>();

        System.out.println(enlazada + ", size=  " + enlazada.size());
        System.out.println(enlazada + "empty= " + enlazada.isEmpty());

        enlazada.add(new Alumno("Naruto", 10));
        enlazada.add(new Alumno("Luffy", 9));
        enlazada.add(new Alumno("Saitama", 7));
        enlazada.add(new Alumno("Goku", 8));
        enlazada.add(new Alumno("Kirito", 2));
        enlazada.add(new Alumno("Kira", 6));
        enlazada.add(new Alumno( "Ichigo", 4));
        enlazada.add(new Alumno("Eren", 5));


        System.out.println(enlazada + ", size=  " + enlazada.size());

        enlazada.addFirst(new Alumno("Yugi", 10));
        enlazada.addLast(new Alumno("Kagome", 8));
        System.out.println(enlazada + ", size=  " + enlazada.size());

        System.out.println("enlazada.getFirst() = " + enlazada.getFirst());
        System.out.println("enlazada.getLast() = " + enlazada.getLast());
        System.out.println("enlazada.get(5) = " + enlazada.get(5));

        enlazada.removeFirst();
        enlazada.removeLast();

        System.out.println(enlazada + ", size=  " + enlazada.size());

        enlazada.remove(new Alumno("Kira", 6));

        System.out.println(enlazada + ", size=  " + enlazada.size());

        Alumno a = new Alumno("Kira", 6);
        enlazada.addLast(a);
        System.out.println(enlazada + ", size=  " + enlazada.size());
        System.out.println("Indice Kira =  " + enlazada.indexOf(a));

       enlazada.set(3, new Alumno("Genos", 7));
       System.out.println(enlazada + ", size=  " + enlazada.size());

        ListIterator<Alumno> li = enlazada.listIterator();
        while (li.hasNext()){
            Alumno al = li.next();
            System.out.println(al);
        };

        System.out.println("====================================");
        while (li.hasPrevious()){
            Alumno al = li.previous();
            System.out.println(al);
        };





    }
}
