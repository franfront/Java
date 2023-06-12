package org.ffernandez.appmockito.ej.repositories;

import org.ffernandez.appmockito.ej.models.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepoOtro implements ExamenRepository {
    @Override
    public List<Examen> findAll() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("ExamenRepoOtro.findAll");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
