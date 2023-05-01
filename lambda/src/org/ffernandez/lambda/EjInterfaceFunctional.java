package org.ffernandez.lambda;

import org.ffernandez.lambda.aritmetica.AritmeticaInterface;
import org.ffernandez.lambda.aritmetica.Calculadora;

public class EjInterfaceFunctional {
    public static void main(String[] args) {

        AritmeticaInterface suma = Double::sum;
        AritmeticaInterface resta = (a, b) -> a - b;
        AritmeticaInterface multiplicacion = (a, b) -> a * b;
        AritmeticaInterface division = (a, b) -> a / b;

        Calculadora c = new Calculadora();

        System.out.println("Suma: " + c.operacion(100, 50, suma));
        System.out.println("Resta: " + c.operacion(10, 5, resta));
        System.out.println("Multiplicacion: " + c.operacion(20, 2, multiplicacion));
        System.out.println("Division: " + c.operacion(1000, 5, division));

        System.out.println("Suma2: " + c.operacionBiFunction(100, 50, Double::sum));
        System.out.println("Resta2: " + c.operacionBiFunction(10, 5, (a, b) -> a - b));
        System.out.println("Multiplicacion2: " + c.operacionBiFunction(20, 2, (a, b) -> a * b));
        System.out.println("Division2: " + c.operacionBiFunction(1000, 5, (a, b) -> a / b));


    }
}
