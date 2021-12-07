package org.curso.gea.repository.config;

import org.curso.gea.domain.config.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
