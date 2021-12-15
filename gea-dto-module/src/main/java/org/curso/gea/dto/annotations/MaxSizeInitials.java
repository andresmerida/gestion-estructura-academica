package org.curso.gea.dto.annotations;

import org.curso.gea.dto.annotations.impl.MaxSizeInitialsValidation;
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
@Constraint(validatedBy = MaxSizeInitialsValidation.class)
@Documented
public @interface MaxSizeInitials {
    String message() default "Max size Initial should be 3";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
