package org.ffernandez.interfaces.imprenta.modelo;

public class Informe extends Hoja implements Imprimible{

    private Persona autor;
    private Persona revisor;

    public Informe(Persona autor, Persona revisor,String texto) {
        super(texto);
        this.autor = autor;
        this.revisor = revisor;
    }
    @Override
    public String imprimir() {
        return "Informe escrito por " + autor
                + " revisado por " + revisor
                + "\n" + " con el texto: " + this.texto;
    }
}
