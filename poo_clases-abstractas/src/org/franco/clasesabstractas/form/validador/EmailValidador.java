package org.franco.clasesabstractas.form.validador;

public class EmailValidador extends Validador {

    protected String mensaje = "El campo %s debe ser un email válido";

    private final static String EMAIL_PATTERN = "^(.+)@(.+)$";

    @Override
    public void setMensajeError(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensajeError() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(EMAIL_PATTERN);
    }
}
