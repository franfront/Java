package org.ffernandez.optional.ej;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;

public class EjOptional {
    public static void main(String[] args) {

        System.out.println("********** Creando Optional **********");
        String nombre = "Franco";
        Optional<String> nombreOptional = Optional.of(nombre);

        System.out.println("nombreOptional = " + nombreOptional);
        System.out.println("nombreOptional.isPresent() = " + nombreOptional.isPresent());

        nombreOptional.ifPresentOrElse((valor) ->{
            System.out.println("hola " + valor);
        } , () -> System.out.println("No esta presente"));


        System.out.println("********** Creando Optional vacio **********");
        nombre = null;
        nombreOptional = Optional.ofNullable(nombre);
        System.out.println("nombreOptional = " + nombreOptional);
        System.out.println("nombreOptional.isPresent() = " + nombreOptional.isPresent());
        System.out.println("nombreOptional.isEmpty() = " + nombreOptional.isEmpty());

        nombreOptional.ifPresentOrElse((valor) ->{
            System.out.println("hola " + valor);
        } , () -> System.out.println("No esta presente"));


        System.out.println("********** Creando Optional vacio **********");

        Optional<String> nombreOptionalVacio = Optional.empty();

        System.out.println("nombreOptionalVacio = " + nombreOptionalVacio);
        System.out.println("nombreOptionalVacio.isPresent() = " + nombreOptionalVacio.isPresent());









    }



}
