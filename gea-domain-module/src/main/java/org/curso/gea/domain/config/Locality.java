package org.curso.gea.domain.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locality")
@Data
@NoArgsConstructor
public class Locality {

    @EmbeddedId
    private LocalityPK localityPK;

    private String name;
    private String initials;
    private Boolean active;

    // IMPORTANT NOTE: EAGER just for exceptional cases (mandatory relationships) LAZY is the common for use.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityId", nullable = false, insertable = false, updatable = false)
    private City city;
}
