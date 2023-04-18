package org.franco.clasesabstractas.form.validador;

public  abstract class Validador {

    protected String mensajeError;
    abstract public void setMensajeError(String mensaje);
    abstract public String getMensajeError();

    public abstract boolean esValido(String valor);

}
