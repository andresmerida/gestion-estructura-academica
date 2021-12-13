package org.curso.gea.service.config;

import org.curso.gea.dto.config.CityDTO;
import org.curso.gea.service.CrudServiceBase;

import java.util.List;

public interface CityService extends CrudServiceBase<CityDTO, Integer> {
    List<CityDTO> findAllActiveWithCountry();
}
