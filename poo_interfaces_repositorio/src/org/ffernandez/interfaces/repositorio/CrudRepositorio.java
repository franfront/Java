package org.ffernandez.interfaces.repositorio;


import org.ffernandez.interfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
   T porId(Integer id) throws AccesoDatoException;
    void guardar(T t) throws AccesoDatoException;
    void editar(T t) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;


}
