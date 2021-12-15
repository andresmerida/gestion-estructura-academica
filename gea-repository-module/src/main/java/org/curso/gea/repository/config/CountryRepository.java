package org.curso.gea.repository.config;

import org.curso.gea.domain.config.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> getFirstByName(String countryName);
}
