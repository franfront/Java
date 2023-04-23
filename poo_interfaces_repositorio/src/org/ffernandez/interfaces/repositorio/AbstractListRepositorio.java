package org.ffernandez.interfaces.repositorio;


import org.ffernandez.interfaces.modelo.BaseEntity;
import org.ffernandez.interfaces.repositorio.excepciones.*;


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
    public T porId(Integer id) throws LecturaAccesoDatoException {

        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("El id no puede ser nulo o menor o igual a cero");
        }

        T resultado = null;
        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        if (resultado == null)
            throw new LecturaAccesoDatoException("No se encontro el cliente con id: " + id);



        return resultado;
    }


    @Override
    public void guardar(T t) throws EscrituraAccesoDatoException {
        if(t == null)
            throw new EscrituraAccesoDatoException("El objeto no puede ser nulo");

        if(this.dataSource.contains(t))
            throw new RegistroDuplicadoExcepcion("El objeto " + t.getId() +" ya existe en la base de datos");
        this.dataSource.add(t);

    }



    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
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
