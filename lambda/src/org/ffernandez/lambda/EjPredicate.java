package org.ffernandez.lambda;

import org.ffernandez.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjPredicate {
    public static void main(String[] args) {

        Predicate<Integer> predicate = num -> num > 10;
        boolean resultado = predicate.test(5);
        System.out.println("resultado = " + resultado);

        Predicate<String> predicate2 = role -> role.equals("ROLE_ADMIN");
        System.out.println("resultado2 = " + predicate2.test("ROLE_USER"));

        BiPredicate<String, String> biPredicate = String::equals;
        System.out.println("biPredicate = " + biPredicate.test("hola", "hola"));

        BiPredicate<Integer, Integer> biPredicate2 = (x, y) -> x > y;
        boolean resultado2 = biPredicate2.test(10, 5);
        System.out.println("biPredicate2 = " + resultado2);

        Usuario usuario = new Usuario();
        Usuario usuario2 = new Usuario();
        usuario.setNombre("Franco");
        usuario2.setNombre("Denise");

        BiPredicate<Usuario, Usuario> biPredicate3 = (u1, u2) -> u1.getNombre().equals(u2.getNombre());
        boolean resultado3 = biPredicate3.test(usuario, usuario2);
        System.out.println("resultado3 = " + resultado3);


    }
}
