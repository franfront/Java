package org.ffernandez.excepciones.ejemplo;

public class Calculadora {

    public double division(int numerador, int denominador) throws DisivionZeroException {
        if (denominador == 0) {
            throw new DisivionZeroException("No se puede dividir entre cero");
        }
        return  numerador / (double) denominador;
    }

    public double division(String numerador, String denominador) throws DisivionZeroException, FormatNumberException {

        try {
            int num = Integer.parseInt(numerador);
            int den = Integer.parseInt(denominador);
            return this.division(num, den);

        } catch (NumberFormatException nfe) {
            throw new FormatNumberException("Debe ingresar un numero");
        }

    }


}
