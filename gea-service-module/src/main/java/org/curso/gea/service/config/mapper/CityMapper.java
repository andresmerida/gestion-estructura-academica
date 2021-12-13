package org.curso.gea.service.config.mapper;

import org.curso.gea.domain.config.City;
import org.curso.gea.domain.config.Country;
import org.curso.gea.dto.config.CityDTO;
import org.curso.gea.service.CustomMapper;
import org.springframework.stereotype.Component;

@Component
public class CityMapper implements CustomMapper<CityDTO, City> {

    private final CountryMapper countryMapper;

    public CityMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @Override
    public CityDTO toDto(City city) {
        var dto = new CityDTO();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setInitials(city.getInitials());
        dto.setActive(city.getActive());
        return dto;
    }

    @Override
    public City toEntity(CityDTO cityDTO) {
        var city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setInitials(cityDTO.getInitials());
        city.setActive(cityDTO.getActive());

        Country country = countryMapper.toEntity(cityDTO.getCountryDTO());
        city.setCountry(country);
        return city;
    }

    public CityDTO toDtoWithCountry(City city) {
        var dto = new CityDTO();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setInitials(city.getInitials());
        dto.setActive(city.getActive());

        dto.setCountryDTO(countryMapper.toDto(city.getCountry()));

        return dto;
    }
}
