package org.curso.gea.dto.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.curso.gea.dto.annotations.MaxSizeInitials;
import org.curso.gea.dto.annotations.UniqueCountryName;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO implements Serializable {
    private Integer id;

    @NotNull(message = "Name is required")
    @UniqueCountryName
    private String name;

    @NotNull(message = "Initials is required")
    @MaxSizeInitials
    private String initials;

    private Boolean active = Boolean.TRUE;
}
