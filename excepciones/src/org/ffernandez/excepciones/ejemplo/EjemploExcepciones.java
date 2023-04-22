package org.ffernandez.excepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {
        String valor = JOptionPane.showInputDialog("Introduce un número");


        try{
            int divisor = Integer.parseInt(valor);
            int division = 10 / divisor;
            System.out.println("El resultado de la división es: " + division);
        } catch (NumberFormatException nfe) {
            System.out.println("Ingrese un valor numerico" );
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
