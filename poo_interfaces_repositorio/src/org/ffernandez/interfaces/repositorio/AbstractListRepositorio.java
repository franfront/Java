package org.ffernandez.interfaces.repositorio;


import org.ffernandez.interfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepositorio<T extends BaseEntity> implements FullRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) {
        T resultado = null;
        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }


    @Override
    public void guardar(T t) {
        this.dataSource.add(t);

    }



    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));

    }




    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }





    @Override
    public int total() {
       return dataSource.size();
    }
}
