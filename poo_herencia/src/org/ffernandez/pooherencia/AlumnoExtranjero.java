package org.ffernandez.pooherencia;

public class AlumnoExtranjero extends  Alumno{
    private String pais;
    private double notaIdiomas;

    public AlumnoExtranjero(){
        System.out.println("Inicializando constructor AlumnoExtranjero");
    }

    public AlumnoExtranjero(String nombre, String apellido, String pais) {
        super(nombre, apellido);
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getNotaIdiomas() {
        return notaIdiomas;
    }

    public void setNotaIdiomas(double notaIdiomas) {
        this.notaIdiomas = notaIdiomas;
    }

    @Override
    public String saludar() {
        return super.saludar() + " " + getApellido() + " y soy de " + getPais() + ".";
    }
}
