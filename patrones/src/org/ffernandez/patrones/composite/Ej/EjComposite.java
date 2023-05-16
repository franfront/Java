package org.ffernandez.patrones.composite.Ej;

import org.ffernandez.patrones.composite.Archivo;
import org.ffernandez.patrones.composite.Directorio;

public class EjComposite {
    public static void main(String[] args) {
        Directorio doc = new Directorio("Documentos");

        Directorio java = new Directorio("Java");
       java.add(new Archivo("patrones.pdf"));

       Directorio stream = new Directorio("Api Stream");
       stream.add(new Archivo("stream-map.pdf"));

       java.add(stream);


       doc.add(java);
       doc.add(new Archivo("cv.pdf"));
       doc.add(new Archivo("foto.jpg"));

        System.out.println(doc.mostrar(0));


    }
}
