package org.curso.gea.repository.config;

import org.curso.gea.domain.config.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
