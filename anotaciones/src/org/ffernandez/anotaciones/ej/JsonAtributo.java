package org.ffernandez.anotaciones.ej;


import java.lang.annotation.*;

@Documented // Para que aparezca en la documentacion
@Target(ElementType.FIELD) // Sobre que elementos se puede aplicar
@Retention(RetentionPolicy.RUNTIME) // Cuando se aplica la anotacion
public @interface JsonAtributo {
    String nombre() default ""; // Valor por defecto
    boolean mayuscula() default false;


}
