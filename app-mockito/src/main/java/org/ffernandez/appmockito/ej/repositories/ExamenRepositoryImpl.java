package org.ffernandez.appmockito.ej.repositories;

import org.ffernandez.appmockito.ej.models.Examen;

import java.util.Arrays;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepository {
    @Override
    public List<Examen> findAll() {
        return Arrays.asList(new Examen(1L, "Matematicas"), new Examen(2L, "Lenguaje"), new Examen(3L, "Historia"), new Examen(4L, "Fisica"));
    }
}
