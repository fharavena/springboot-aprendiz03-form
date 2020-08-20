package com.bolsadeideas.springboot.app.springbootform.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IdentificadorRegexValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})

public @interface identificadorRegex{
    String message() default "Identificador invalido mediante IdentificadorRegexValidador";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}