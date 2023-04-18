package org.ffernandez.app.hogar;

public class Persona {
    private String nombre;

    public static  final String GENERO_MASCULINO = "Masculino";
    public static final String GENERO_FEMENINO = "Femenino";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String lanzarPelota(){
        return "lanza la pelota";
    }

    public static String saludar(){
        return "Hola que tal";
    }
}
