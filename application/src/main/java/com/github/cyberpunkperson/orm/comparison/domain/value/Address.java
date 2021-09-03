package com.github.cyberpunkperson.orm.comparison.domain.value;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Address {

    @Id
    private UUID id;

    private String country;

    private String city;

    private String street;

    private Integer zip;

}
