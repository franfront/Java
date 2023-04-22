package org.ffernandez.interfaces.modelo;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int ultimoId;



    public BaseEntity() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // se verifica si los dos objetos son idénticos (es decir, apuntan a la misma referencia de memoria)
        if (o == null || getClass() != o.getClass()) return false; // verifica si el objeto pasado como parámetro es nulo o si el objeto actual y el pasado como parámetro son de distinto tipo
        BaseEntity base = (BaseEntity) o; // convierte el objeto pasado como parámetro a Cliente
        return Objects.equals(id, base.id); // verifica si el id del objeto actual es igual al id del objeto pasado como parámetro
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
