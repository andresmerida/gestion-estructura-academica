package org.curso.gea.web.rest.config;

import org.curso.gea.dto.config.CountryDTO;
import org.curso.gea.service.config.CountryService;
import org.curso.gea.web.rest.exceptions.BadRequestAlertException;
import org.curso.gea.web.rest.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import static org.curso.gea.web.rest.exceptions.ErrorConstants.ID_INVALID_BAD_REQUEST;
import static org.curso.gea.web.rest.exceptions.ErrorConstants.ID_NULL_BAD_REQUEST;

@RestController
@RequestMapping("/v1/config/countries")
public class CountryResource {

    private final Logger log = LoggerFactory.getLogger(CountryResource.class);

    private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * {@code GET  /v1/config/countries} : get countries according to the query param.
     * @param justActive boolean that if it is true get only active countries, in opposite case get all countries
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of countries in body.
     */
    @GetMapping
    public ResponseEntity<List<CountryDTO>> getCountries(@RequestParam(name = "justActive", defaultValue = "true") boolean justActive) {
        if (justActive) {
            return ResponseEntity.ok().body(countryService.findAllActive());
        } else {
            return ResponseEntity.ok().body(countryService.findAll());
        }
    }

    /**
     * {@code GET  /v1/config/countries/:id} : get countryDTO by id.
     * @param id the id of the countryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the countryDTO,
     * or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable Integer id) {
        CountryDTO dto = countryService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Country with id: %s is not existed",
                        id.toString()), "country"));

        return ResponseEntity.ok(dto);
    }

    /**
     * {@code POST  /v1/config/countries} : Create a new Country.
     * @param countryDTO the countryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new countryDTO,
     * or with status {@code 400 (Bad Request)} if the country has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) throws URISyntaxException {
        log.debug("REST request to create a Country : {}", countryDTO);

        if (countryDTO.getId() != null) {
            throw new BadRequestAlertException("A new country cannot already have an ID", "country", "idexists");
        }

        CountryDTO dtoDB = countryService.save(countryDTO);

        return ResponseEntity.created(new URI("/v1/config/countries/" + dtoDB.getId()))
                .body(dtoDB);
    }

    /**
     * {@code PUT  /v1/config/countries/:id} : Updates an existing country.
     *
     * @param id the id of the country to save.
     * @param countryDTO the country to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated country,
     * or with status {@code 400 (Bad Request)} if the country is not valid,
     * or with status {@code 500 (Internal Server Error)} if the country couldn't be updated.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody CountryDTO countryDTO, @PathVariable Integer id) {
        log.debug("REST request to update Country : {}, {}", id, countryDTO);

        if (countryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid Country ID, null value", "country", ID_NULL_BAD_REQUEST);
        }

        if (!Objects.equals(id, countryDTO.getId())) {
            throw new BadRequestAlertException("Invalid Country ID,  differents ids", "country", ID_INVALID_BAD_REQUEST);
        }

        CountryDTO dto = countryService.save(countryDTO);

        return ResponseEntity.ok().body(dto);
    }

    /**
     * {@code PATCH  /countries/:id} : It change active boolean attribute to false
     * @param id the id of the Country
     * @return the ResponseEntity with status 204 (noContent)
     * or with status {@code 404 (Not Found)}.
     * or with status {@code 500 (Internal Server Error)} if the country id does not exist.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> logicalDeleteCountry(@PathVariable Integer id) {
        if (!countryService.findById(id).isPresent()) {
            throw new ResourceNotFoundException(String.format("Country with id: %s is not existed", id.toString()), "country");
        }

        countryService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }
}
