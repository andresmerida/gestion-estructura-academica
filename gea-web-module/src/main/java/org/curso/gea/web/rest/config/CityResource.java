package org.curso.gea.web.rest.config;

import org.curso.gea.dto.config.CityDTO;
import org.curso.gea.service.config.CityService;
import org.curso.gea.web.rest.exceptions.BadRequestAlertException;
import org.curso.gea.web.rest.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/config/cities")
public class CityResource {

    private final Logger log = LoggerFactory.getLogger(CityResource.class);

    private final CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable Integer id) {
        CityDTO dto = cityService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id: %s is not existed",
                        id.toString()), "city"));

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO) throws URISyntaxException {
        log.debug("REST request to create a City : {}", cityDTO);

        if (cityDTO.getId() != null) {
            throw new BadRequestAlertException("A new city cannot already have an ID", "city", "idexists");
        }

        CityDTO dtoDB = cityService.save(cityDTO);

        return ResponseEntity.created(new URI("/v1/config/cities/" + dtoDB.getId()))
                .body(dtoDB);
    }
}
