package org.ffernandez.appmockito.ej.services;

import org.ffernandez.appmockito.ej.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static List<Examen> EXAMENES = Arrays.asList(new Examen(1L, "Matematicas"), new Examen(2L, "Lenguaje"), new Examen(3L, "Historia"), new Examen(4L, "Fisica"));

    public final static List<String> PREGUNTAS = Arrays.asList("aritmetica", "integrales", "derivadas", "trigonometria", "geometria");

    public final static Examen EXAMEN = new Examen(null, "Fisica");
}
