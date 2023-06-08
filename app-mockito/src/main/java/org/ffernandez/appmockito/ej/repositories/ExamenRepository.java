package org.ffernandez.appmockito.ej.repositories;
import org.ffernandez.appmockito.ej.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();

}
