package org.ffernandez.pooherencia;

public class Alumno extends Persona {
    private String colegio;
    private double notaMatematica;
    private double notaIngles;
    private double notaHistoria;

    public Alumno(){
        System.out.println("Inicializando constructor Alumno");
    }

    public Alumno(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Alumno(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);

    }

    public Alumno(String nombre, String apellido, int edad, String colegio) {
        super(nombre, apellido, edad);
        this.colegio = colegio;

    }




    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaIngles() {
        return notaIngles;
    }

    public void setNotaIngles(double notaIngles) {
        this.notaIngles = notaIngles;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    @Override
    public String saludar(){
        String mensaje = super.saludar();
        return mensaje + ", soy un alumno, mi nombre es: " + getNombre();
    }

}
