package org.ffernandez.ejemplos.list;

import org.ffernandez.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EjArrayList {
    public static void main(String[] args) {

        List<Alumno> al = new ArrayList<>();

        System.out.println(al + ", size=  " + al.size());
        System.out.println(al + "empty= " + al.isEmpty());

        al.add(new Alumno("Naruto", 10));
        al.add(new Alumno("Luffy", 9));
        al.add(new Alumno("Saitama", 7));
        al.add(new Alumno("Goku", 8));
        al.add(new Alumno("Kirito", 2));
        al.add(new Alumno("Kira", 6));
        al.add(2, new Alumno( "Ichigo", 4));
        al.set(3, new Alumno("Eren", 8));


        System.out.println(al + ", size=  " + al.size());

        //al.remove(new Alumno("Kirito", 2));
        al.remove(6);
        System.out.println(al + ", size=  " + al.size());

        boolean b = al.contains(new Alumno("Kirito", 2));
        System.out.println("b = " + b);

        Object a[] = al.toArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }



    }
}
