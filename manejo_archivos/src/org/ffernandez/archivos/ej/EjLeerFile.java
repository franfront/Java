package org.ffernandez.archivos.ej;

import org.ffernandez.archivos.ej.service.FileService;

public class EjLeerFile {
    public static void main(String[] args) {

        FileService service = new FileService();

        System.out.println(service.leerFile("Ruta\\java.txt"));


    }
}
