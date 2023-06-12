package org.ffernandez.appmockito.ej.services;

import org.ffernandez.appmockito.ej.models.Examen;
import org.ffernandez.appmockito.ej.repositories.ExamenRepoOtro;
import org.ffernandez.appmockito.ej.repositories.ExamenRepository;
import org.ffernandez.appmockito.ej.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExamenServiceImplTest {
    ExamenRepository repository;
    ExamenService service;
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp() {
       repository = mock(ExamenRepoOtro.class); // creamos un mock que simula el comportamiento de la clase ExamenRepository
       preguntaRepository = mock(PreguntaRepository.class);
        service = new ExamenServiceImpl(repository, preguntaRepository);

    }

    @Test
    void findExamenPorNombre() {
        List<Examen> datos = Arrays.asList(new Examen(1L, "Matematicas"), new Examen(2L, "Lenguaje"), new Examen(3L, "Historia"), new Examen(4L, "Fisica"));
        when(repository.findAll()).thenReturn(datos); // cuando se llame al metodo findAll() del mock repository, retornara la lista datos

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");



        assertTrue(examen.isPresent());
        assertEquals(1L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.get().getNombre());
    }

    @Test
    void findExamenPorNombreEmpty() {

        List<Examen> datos = Collections.emptyList();

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");



        assertFalse(examen.isPresent());

    }
}