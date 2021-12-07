package org.curso.gea.web.rest.config;

import org.curso.gea.dto.config.CountryDTO;
import org.curso.gea.service.config.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/config/countries")
public class CountryResource {

    private final Logger log = LoggerFactory.getLogger(CountryResource.class);

    private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getCountries(@RequestParam(name = "active", defaultValue = "true") boolean active) {
        if (active) {
            return countryService.findAllActive();
        } else {
            return countryService.findAll();
        }
    }
}