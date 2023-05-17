package org.ffernandez.patrones.observer.ej;

import org.ffernandez.patrones.observer.UsuarioRepo;

public class EjObserver2 {
    public static void main(String[] args) {
        UsuarioRepo repo = new UsuarioRepo();
        repo.addObserver((obs, obj) -> System.out.println("Enviando correo al usuario " + obj));
        repo.addObserver((obs, obj) -> System.out.println("Enviando correo al administrador " + obj));
        repo.addObserver((obs, obj) -> System.out.println("Enviando correo al auditor " + obj));
        repo.crearUsuario("Franco");
    }
}
