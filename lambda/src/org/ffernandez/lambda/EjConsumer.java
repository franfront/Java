package org.ffernandez.lambda;

import org.ffernandez.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjConsumer {
    public static void main(String[] args) {

        Consumer<Date> consumer = fecha -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sdf.format(fecha));
        };

        consumer.accept(new Date());


        BiConsumer<String, Integer> biConsumer = (nombre, edad) -> System.out.println(nombre + " tiene " + edad + " años");

        biConsumer.accept("Franco", 21);

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hola mundo lambda!");

        List<String> nombres = Arrays.asList("Franco", "Fernandez", "Java", "Lambda");
        nombres.forEach(consumer2);


        Supplier<Usuario> crearUsuario = Usuario::new;
        Usuario usuario = crearUsuario.get();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;

        asignarNombre.accept(usuario, "Franco");
        System.out.println("Nombre de usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola mundo lambda supplier!";


        System.out.println(proveedor.get());

    }
}
