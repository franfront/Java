package org.ffernandez.interfaces.repositorio;

public interface FullRepositorio<T> extends CrudRepositorio<T>, OrdenableRepositorio<T>, PaginableRepositorio<T>, Contable{

}
