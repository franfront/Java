package org.ffernandez.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjFunction {
    public static void main(String[] args) {
        Function<String, String> function1 =  nombre -> "Hola " + nombre;

        String resultado = function1.apply("Franco");
        System.out.println(resultado);

        Function<String, String> function2 = String::toUpperCase;
        System.out.println(function2.apply("Franco"));

        BiFunction<Integer, Integer, Integer> function3 = Integer::sum;
        Integer resultado2 = function3.apply(5, 10);
        System.out.println(resultado2);

        BiFunction<String, String, Integer> function4 = String::compareTo;
        Integer resultado3 = function4.apply("Franco", "Franco");
        System.out.println("El resultado es " + resultado3);

        BiFunction<String, String,String> function5 = String::concat;

        System.out.println(function5.apply("Franco ", "Fernandez"));



    }
}
