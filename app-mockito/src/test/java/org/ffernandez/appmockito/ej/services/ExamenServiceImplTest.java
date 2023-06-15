package org.ffernandez.appmockito.ej.services;

import org.ffernandez.appmockito.ej.models.Examen;
import org.ffernandez.appmockito.ej.repositories.ExamenRepoOtro;
import org.ffernandez.appmockito.ej.repositories.ExamenRepository;
import org.ffernandez.appmockito.ej.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) // habilita las anotaciones mock
class ExamenServiceImplTest {
    @Mock
    ExamenRepository repository;
    @Mock
    PreguntaRepository preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // otra forma de habilitar las anotaciones mock


//       repository = mock(ExamenRepoOtro.class); // creamos un mock que simula el comportamiento de la clase ExamenRepository
//       preguntaRepository = mock(PreguntaRepository.class);
//       service = new ExamenServiceImpl(repository, preguntaRepository);

    }

    @Test
    void findExamenPorNombre() {

        when(repository.findAll()).thenReturn(Datos.EXAMENES); // cuando se llame al metodo findAll() del mock repository, retornara la lista datos
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

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmetica"));

    }

    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmetica"));

        verify(repository).findAll(); // verifica que se haya llamado al metodo findAll() del mock repository
        verify(preguntaRepository).findPreguntasPorExamenId(1L); // verifica que se haya llamado al metodo findPreguntasPorExamenId() del mock preguntaRepository

    }

    @Test
    void testExamenVerifyEmpty() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas2");

        assertNull(examen);

        verify(repository).findAll(); // verifica que se haya llamado al metodo findAll() del mock repository
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong()); // verifica que se haya llamado al metodo findPreguntasPorExamenId() del mock preguntaRepository




    }
}