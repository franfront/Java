package org.ffernandez.archivos.ej;

import org.ffernandez.archivos.ej.service.FileService;

public class EjCrearFile {
    public static void main(String[] args) {
        String nombreArchivo = "\"Ruta\\\\java.txt\"";

        FileService service = new FileService();

        service.crearFile(nombreArchivo);

    }
}
