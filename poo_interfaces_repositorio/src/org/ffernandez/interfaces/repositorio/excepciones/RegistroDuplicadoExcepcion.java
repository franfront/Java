package org.ffernandez.interfaces.repositorio.excepciones;

public class RegistroDuplicadoExcepcion extends EscrituraAccesoDatoException{
    public RegistroDuplicadoExcepcion(String message) {
        super(message);
    }

}
