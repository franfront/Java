package org.franco.clasesabstractas.form;

import org.franco.clasesabstractas.form.elementos.*;
import org.franco.clasesabstractas.form.elementos.select.Opcion;
import org.franco.clasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
            edad.addValidador(new Numerovalidador());

        TextareaForm experiencia = new TextareaForm("experiencia", 5, 20);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "PHP"))
                .addOpcion(new Opcion("3", "Python"))
                .addOpcion(new Opcion("4", "C#"))
                .addOpcion(new Opcion("5", "C++").setSeleccionada());

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+this.nombre+"' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola, este campo está deshabilitado");
        username.setValor("jhon.doe");
        password.setValor("123456");
        email.setValor("jhon.doe@correo.com");
        edad.setValor("25");
        experiencia.setValor("mas de un año de experiencia");


        /* List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);
         */
        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);


        /*for(ElementoForm e : elementos) {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
         */

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if (!e.esvalido()) {

                e.getErrores().forEach(System.out::println);
            }
        });




    }
}
