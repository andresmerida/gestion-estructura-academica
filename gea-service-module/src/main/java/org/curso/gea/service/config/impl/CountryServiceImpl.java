package org.curso.gea.service.config.impl;

import org.curso.gea.domain.config.Country;
import org.curso.gea.dto.config.CountryDTO;
import org.curso.gea.repository.config.CountryRepository;
import org.curso.gea.service.config.CountryService;
import org.curso.gea.service.config.mapper.CountryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }


    @Override
    public CountryDTO save(CountryDTO countryDTO) {
        var country = countryMapper.toEntity(countryDTO);
        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CountryDTO> findById(Integer id) {
        return countryRepository.findById(id).map(countryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountryDTO> findAll() {
        return countryRepository.findAll().stream().map(countryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountryDTO> findAllActive() {
        List<Country> countriesActive = countryRepository.findAll().stream()
                .filter(Country::getActive)
                .collect(Collectors.toList());
        return countriesActive.stream().map(countryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void logicalDelete(Integer id) {
        var country = countryRepository.getById(id);
        country.setActive(Boolean.FALSE);
        countryRepository.save(country);
    }
}
