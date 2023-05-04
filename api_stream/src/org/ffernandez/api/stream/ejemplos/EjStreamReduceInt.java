package org.ffernandez.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjStreamReduceInt {
    public static void main(String[] args) {

        Stream<Integer> nombres = Stream.of(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
        
        int resultado = nombres.reduce(0, Integer::sum);

        System.out.println(resultado);









    }
}
