package org.ffernandez.anotaciones.ej;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Cuando se aplica la anotacion
@Target(ElementType.METHOD) // Sobre que elementos se puede aplicar
public @interface Init {
}
