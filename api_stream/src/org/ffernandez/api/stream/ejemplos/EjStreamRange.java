package org.ffernandez.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class EjStreamRange {
    public static void main(String[] args) {

        IntStream numbers =  IntStream.range(1, 11).peek(System.out::println);
        
        //int resultado = numbers.reduce(0, Integer::sum);

        //int resultado = numbers.sum();

        IntSummaryStatistics resultado = numbers.summaryStatistics();

        System.out.println("Maximo: " + resultado.getMax());
        System.out.println("Minimo: " + resultado.getMin());
        System.out.println("Suma: " + resultado.getSum());
        System.out.println("Promedio: " + resultado.getAverage());
        System.out.println("Cantidad: " + resultado.getCount());









    }
}
