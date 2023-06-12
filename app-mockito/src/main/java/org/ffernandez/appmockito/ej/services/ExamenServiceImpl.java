package org.ffernandez.appmockito.ej.services;

import org.ffernandez.appmockito.ej.models.Examen;
import org.ffernandez.appmockito.ej.repositories.ExamenRepository;
import org.ffernandez.appmockito.ej.repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository repository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository repository, PreguntaRepository preguntaRepository) {
        this.repository = repository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
       return  repository.findAll()
                .stream()
                .filter(examen -> examen.getNombre().equals(nombre))
                .findFirst();

    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if (examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }
}
