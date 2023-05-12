package org.ffernandez.patrones.singleton;

public class ConexionBDSingleton {

    private static ConexionBDSingleton instancia;
    private ConexionBDSingleton() {
        System.out.println("Conectando a la BD");
    }

    public static ConexionBDSingleton getInstance() {
        if (instancia == null){
            instancia = new ConexionBDSingleton();
        }
        return instancia;
    }

}
