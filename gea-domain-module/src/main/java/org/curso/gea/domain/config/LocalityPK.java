package org.curso.gea.domain.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class LocalityPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "cityId", nullable = false)
    private Integer cityId;

    @Column(name = "localityId", nullable = false)
    private Integer localityId;
}
