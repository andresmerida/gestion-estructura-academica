package org.curso.gea.repository.config.jdbc;

import org.curso.gea.domain.config.pojo.LocalityDetail;

import java.util.List;

public interface LocalityDetailJdbcRepository {
    List<LocalityDetail> getAllLocalitiesDetail();
}
