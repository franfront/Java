package org.ffernandez.appmockito.ej.repositories;

import org.ffernandez.appmockito.ej.models.Examen;

import java.util.List;

public interface PreguntaRepository {
    List<String> findPreguntasPorExamenId(Long id);
    void guardarVarias(List<String> preguntas);
    Examen guardar(Examen examen);

}
