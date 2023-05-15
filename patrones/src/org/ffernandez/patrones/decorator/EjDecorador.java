package org.ffernandez.patrones.decorator;

import org.ffernandez.patrones.decorator.decorador.MayusculaDecorador;
import org.ffernandez.patrones.decorator.decorador.ReemplazarEspaciosDecorador;
import org.ffernandez.patrones.decorator.decorador.ReversaDecorador;
import org.ffernandez.patrones.decorator.decorador.SubrayadoDecorador;

public class EjDecorador {
    public static void main(String[] args) {

        Formateable texto = new Texto("Hola mundo");

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        //ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayado = new SubrayadoDecorador(mayuscula);
        ReemplazarEspaciosDecorador reemplazar = new ReemplazarEspaciosDecorador(subrayado);


        System.out.println(reemplazar.darFormato());



    }
}
