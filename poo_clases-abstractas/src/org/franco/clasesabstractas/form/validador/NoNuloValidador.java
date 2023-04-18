package org.franco.clasesabstractas.form.validador;

public class NoNuloValidador extends Validador {

    protected String mensaje = "El campo %s no puede estar vacio";

    @Override
    public void setMensajeError(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensajeError() {
        return this.mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return (valor != null );
    }
}

