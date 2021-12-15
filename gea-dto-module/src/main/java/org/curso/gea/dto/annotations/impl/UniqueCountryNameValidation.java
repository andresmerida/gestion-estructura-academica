package org.curso.gea.dto.annotations.impl;

import org.curso.gea.dto.annotations.UniqueCountryName;
import org.curso.gea.repository.config.CountryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCountryNameValidation implements ConstraintValidator<UniqueCountryName, String> {

    private final CountryRepository countryRepository;

    public UniqueCountryNameValidation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void initialize(UniqueCountryName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String countryName, ConstraintValidatorContext constraintValidatorContext) {
        return countryName != null && !countryRepository.getFirstByName(countryName).isPresent();
    }
}
