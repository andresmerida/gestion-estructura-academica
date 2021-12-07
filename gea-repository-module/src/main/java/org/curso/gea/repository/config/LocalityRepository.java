package org.curso.gea.repository.config;

import org.curso.gea.domain.config.Locality;
import org.curso.gea.domain.config.LocalityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalityRepository extends JpaRepository<Locality, LocalityPK> {
}
