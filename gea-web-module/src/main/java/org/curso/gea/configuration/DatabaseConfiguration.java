package org.curso.gea.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"org.curso.gea.repository.*"})
@EnableJpaRepositories({"org.curso.gea.repository.*"})
@EntityScan("org.curso.gea.domain.*")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
