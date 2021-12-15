package org.curso.gea.dto.annotations;

import org.curso.gea.dto.annotations.impl.UniqueCountryNameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCountryNameValidation.class)
@Documented
public @interface UniqueCountryName {
    String message() default "The given country name is already in use";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
