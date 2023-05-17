package org.ffernandez.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo extends Observable {

    private List<String> repo = new ArrayList<>();

    public void crearUsuario(String usuario) {
        repo.add(usuario);
        notifyObservers(usuario);
    }


}
