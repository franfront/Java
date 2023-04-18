package org.franco.clasesabstractas.form.validador;

public class Numerovalidador extends Validador {

    protected String mensaje = "El campo %s debe ser numerico";

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
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

