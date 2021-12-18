package org.curso.gea.service.config.impl;

import org.curso.gea.domain.config.pojo.LocalityDetail;
import org.curso.gea.repository.config.jdbc.LocalityDetailJdbcRepository;
import org.curso.gea.service.config.LocalityDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityDetailServiceImpl implements LocalityDetailService {

    private final LocalityDetailJdbcRepository localityDetailJdbcRepository;

    public LocalityDetailServiceImpl(LocalityDetailJdbcRepository localityDetailJdbcRepository) {
        this.localityDetailJdbcRepository = localityDetailJdbcRepository;
    }

    @Override
    public List<LocalityDetail> getAllLocalitiesDetail() {
        return localityDetailJdbcRepository.getAllLocalitiesDetail();
    }
}
