package org.curso.gea.repository.config.jdbc.impl.mapper;

import org.curso.gea.domain.config.pojo.LocalityDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalityDetailRowMapper implements RowMapper<LocalityDetail> {

    @Override
    public LocalityDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LocalityDetail(
                rs.getString("country_name"),
                rs.getString("country_initials"),
                rs.getString("city_name"),
                rs.getString("city_initials"),
                rs.getString("locality_name"),
                rs.getString("locality_initials")
        );
    }
}
