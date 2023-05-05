package org.ffernandez.api.stream.ejemplos;

import org.ffernandez.api.stream.ejemplos.models.Factura;
import org.ffernandez.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjStreamFactura {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Naruto", "Uzumaki");
        Usuario u2 = new Usuario("Sasuke", "Uchiha");

        u1.addFactura(new Factura("componentes de pc"));
        u1.addFactura(new Factura("ropa"));

        u2.addFactura(new Factura("comida"));
        u2.addFactura(new Factura("zapatos"));

        List<Usuario> usuarios = Arrays.asList(u1, u2);
        usuarios.stream()

                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" Cliente: ")
                        .concat(f.getUsuario().toString())));

        /*for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre());
            usuario.getFacturas().forEach(factura -> System.out.println(factura.getDescripcion()));
        }
         */

    }
}
