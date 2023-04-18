package org.ffernandez.pooherencia;

public class Profesor extends Persona {
    private String asignatura;

    public Profesor(){
        System.out.println("Inicializando constructor Profesor");
    }

    public Profesor(String nombre, String apellido){
        super(nombre, apellido);
    }

    public Profesor(String nombre, String apellido, String asignatura){
        super(nombre, apellido);
        this.asignatura = asignatura;
    }



    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String saludar() {
        return "Buenos días soy el profesor " + getNombre() + " " + getApellido() + " y soy el profesor de " + getAsignatura() + ".";
    }
}
