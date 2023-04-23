package org.ffernandez.excepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();

        String numerador = JOptionPane.showInputDialog("Introduce un número");
        String denominador = JOptionPane.showInputDialog("Introduce un número");


        try{

            double divisionString = cal.division(numerador, denominador);
            System.out.println("El resultado de la división es: " + divisionString);

        }  catch (FormatNumberException e) {
            System.out.println("Ingrese un valor numerico: " + e.getMessage());
             e.printStackTrace(System.out);
        } catch (DisivionZeroException e) {
            System.out.println("Error: " + e.getMessage());
            main(args);
        }


    }
}
