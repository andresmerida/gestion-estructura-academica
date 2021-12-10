package org.curso.gea.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    private Integer id;
    private String name;
    private String initials;
    private Boolean active = Boolean.TRUE;
}
