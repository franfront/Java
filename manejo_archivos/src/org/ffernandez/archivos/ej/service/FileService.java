package org.ffernandez.archivos.ej.service;

import java.io.*;

public class FileService {
    public void crearFile( String nombre) {
        File archivo = new File(nombre);
        try {
            FileWriter escritor = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.append("Tengo mucho sueño")
                    .append(" Me levanté temprano")
                    .append(" Escribo un archivo de texto");
            buffer.close();
            System.out.println("Archivo creado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String leerFile(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                sb.append(linea).append("\n");
                linea = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

}
