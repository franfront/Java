package org.ffernandez.interfaces.imprenta;

import org.ffernandez.interfaces.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculum cv = new Curriculum(new Persona("Franco", "Fernandez"), "Ingeniería Informática", "Resumen de mi vida");
        cv.addExperiencia("Java");
        cv.addExperiencia("Spring");
        cv.addExperiencia("Javascript");
        cv.addExperiencia("Angular");

        Libro libro = new Libro(new Persona("Franco", "Fernandez"), "Angular", Genero.DRAMA);
        libro.addPagina(new Pagina("Componentes"))
                .addPagina(new Pagina("Directivas"))
                .addPagina(new Pagina("Servicios"))
                .addPagina(new Pagina("Pipes"));


        Informe informe = new Informe(new Persona("Franco", "Fernandez"), new Persona("Denise", "Monges"), "Estudio de microservicios");
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);





    }

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
