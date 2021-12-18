package org.curso.gea.repository.config.jdbc.impl;

import org.curso.gea.domain.config.pojo.LocalityDetail;
import org.curso.gea.repository.config.jdbc.LocalityDetailJdbcRepository;
import org.curso.gea.repository.config.jdbc.impl.mapper.LocalityDetailRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocalityDetailJdbcRepositoryImpl implements LocalityDetailJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public LocalityDetailJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LocalityDetail> getAllLocalitiesDetail() {
        var sql = """
                SELECT city.city_id as city_id,
                	city.country_name,
                	city.country_initials,
                	city.city_name,
                	city.city_initials,
                	l.name as locality_name,
                	l.initials as locality_initials
                FROM locality l
                INNER JOIN (
                	SELECT city.id as city_id, country.name as country_name, country.initials as country_initials, city.name as city_name, city.initials as city_initials
                	FROM city city
                	INNER JOIN country country ON city.countryId=country.id
                ) city ON l.cityId=city.city_id
                ORDER BY country_name, city_name, locality_name;
                """;
        return jdbcTemplate.query(sql, new LocalityDetailRowMapper());
    }
}
