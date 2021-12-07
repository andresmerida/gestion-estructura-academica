package org.curso.gea.service.config.mapper;

import org.curso.gea.domain.config.Country;
import org.curso.gea.dto.config.CountryDTO;
import org.curso.gea.service.CustomMapper;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper implements CustomMapper<CountryDTO, Country> {

    @Override
    public CountryDTO toDto(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setId(country.getId());
        dto.setName(country.getName());
        dto.setInitials(country.getInitials());
        dto.setActive(country.getActive());
        dto.setNewAttribute(country.getNewAttribute());
        return dto;
    }

    @Override
    public Country toEntity(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());
        country.setInitials(countryDTO.getInitials());
        country.setActive(countryDTO.getActive());
        country.setNewAttribute(countryDTO.getNewAttribute());
        return country;
    }
}
