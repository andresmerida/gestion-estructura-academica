package org.curso.gea.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO implements Serializable {
    private Integer id;
    private String name;
    private String initials;
    private Boolean active = Boolean.TRUE;

    private CountryDTO countryDTO;
}
