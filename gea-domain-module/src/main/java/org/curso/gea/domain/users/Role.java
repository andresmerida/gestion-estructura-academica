package org.curso.gea.domain.users;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static org.curso.gea.domain.utils.constants.DBConstants.ROLE_TABLE_NAME_DB;

@Entity
@Table(name = ROLE_TABLE_NAME_DB)
@Data
@NoArgsConstructor
public class Role {

    @Id
    @SequenceGenerator(name = "role_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
