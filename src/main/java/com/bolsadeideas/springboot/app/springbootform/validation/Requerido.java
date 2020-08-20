package com.bolsadeideas.springboot.app.springbootform.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = RequeridoValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})

public @interface Requerido {
    String message() default "El Campo es requerido. requeridoValidador";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}