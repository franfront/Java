package org.ffernandez.generics;

import org.ffernandez.interfaces.modelo.Cliente;
import org.ffernandez.interfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenerics {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Franco", "Fernandez"));

        Cliente franco = clientes.iterator().next();

        Cliente[] clientesArray = {
                new Cliente("Franco", "Fernandez"),
                new Cliente("Denise", "Monges"),
        };

        Integer[] numeros = {1, 2, 3, 4, 5};

        List<Cliente> clientesList = fromArrayToList(clientesArray);

        List<Integer> numerosList = fromArrayToList(numeros);

       clientesList.forEach(System.out::println);
       numerosList.forEach(System.out::println);

       List<String> nombres = fromArrayToList(new String[]{"Franco", "Denise"}, numeros);
       nombres.forEach(System.out::println);

       List<ClientePremium> clientesPremiumList = fromArrayToList(
               new ClientePremium[]{new ClientePremium("Franco", "Fernandez")}
       );

         imprimirClientes(clientes);
         imprimirClientes(clientesList);
         imprimirClientes(clientesPremiumList);


    }

    public static <T> List<T> fromArrayToList(T[] cli) {

        return Arrays.asList(cli);
    }


    public static <T extends Number> List<T> fromArrayToList(T[] cli) {

        return Arrays.asList(cli);
    }


    public static <T extends Cliente> List<T> fromArrayToList(T[] cli) {

        return Arrays.asList(cli);
    }

    public static <T, G> List<T> fromArrayToList(T[] cli, G[] x) {
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(cli);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}
