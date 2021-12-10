package org.curso.gea.service;

import java.util.List;
import java.util.Optional;

public interface CrudServiceBase<DTO, T> {
    DTO save(DTO dto);
    Optional<DTO> findById(T id);
    List<DTO> findAll();
    List<DTO> findAllActive();
    void logicalDelete(T id);
}
