package org.curso.gea.dto.annotations.impl;

import org.curso.gea.dto.annotations.MaxSizeInitials;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxSizeInitialsValidation implements ConstraintValidator<MaxSizeInitials, String> {
    @Override
    public void initialize(MaxSizeInitials constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String initials, ConstraintValidatorContext constraintValidatorContext) {
        return !(initials.length() > 3);
    }
}
