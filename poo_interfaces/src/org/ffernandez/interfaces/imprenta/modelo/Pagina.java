package org.ffernandez.interfaces.imprenta.modelo;

public class Pagina extends Hoja implements Imprimible {
    public Pagina(String texto) {
        super(texto);
    }

    @Override
    public String imprimir() {
        return this.texto;
    }
}
