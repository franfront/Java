package org.ffernandez.lambda.aritmetica;

import java.util.function.BiFunction;

public class Calculadora {
    public double operacion(double a, double b, AritmeticaInterface ai) {
        return ai.operacion(a, b);
    }

    public double operacionBiFunction(double a, double b, BiFunction<Double, Double, Double> ai) {
        return ai.apply(a, b);
    }


}
