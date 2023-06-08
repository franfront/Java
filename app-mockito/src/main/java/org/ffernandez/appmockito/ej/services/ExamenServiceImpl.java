package org.ffernandez.appmockito.ej.services;

import org.ffernandez.appmockito.ej.models.Examen;
import org.ffernandez.appmockito.ej.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository repository;

    public ExamenServiceImpl(ExamenRepository repository) {
        this.repository = repository;
    }

    @Override
    public Examen findExamenPorNombre(String nombre) {
        Optional<Examen> examenOptional = repository.findAll()
                .stream()
                .filter(examen -> examen.getNombre().equals(nombre))
                .findFirst();
        Examen examen = null;
        if(examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
        }
        return examen;
    }
}
