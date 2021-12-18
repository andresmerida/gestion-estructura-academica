package org.curso.gea.domain.config.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalityDetail {

    private String countryName;
    private String countryInitials;
    private String cityName;
    private String cityInitials;
    private String localityName;
    private String localityInitials;

}
