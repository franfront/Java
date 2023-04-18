package org.franco.clasesabstractas.form.validador;

public class RequeridoValidador extends Validador {

    protected String mensaje = "El campo %s es requerido";

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
        return (valor != null && valor.length() > 0);
    }
}
