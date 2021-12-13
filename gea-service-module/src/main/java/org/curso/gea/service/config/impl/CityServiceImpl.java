package org.curso.gea.service.config.impl;

import org.curso.gea.domain.config.City;
import org.curso.gea.dto.config.CityDTO;
import org.curso.gea.repository.config.CityRepository;
import org.curso.gea.service.config.CityService;
import org.curso.gea.service.config.mapper.CityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDTO save(CityDTO cityDTO) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(cityDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CityDTO> findById(Integer id) {
        return cityRepository.findById(id).map(cityMapper::toDtoWithCountry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        return cityRepository.findAll().stream().map(cityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDTO> findAllActive() {
        var cityList = cityRepository.findAll().stream()
                .filter(City::getActive)
                .collect(Collectors.toList());
        return cityList.stream().map(cityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void logicalDelete(Integer id) {
        City city = cityRepository.getById(id);
        city.setActive(Boolean.FALSE);
        cityRepository.save(city);
    }

    @Override
    public List<CityDTO> findAllActiveWithCountry() {
        var cityList = cityRepository.findAll().stream()
                .filter(City::getActive)
                .collect(Collectors.toList());
        return cityList.stream().map(cityMapper::toDtoWithCountry).collect(Collectors.toList());
    }
}
