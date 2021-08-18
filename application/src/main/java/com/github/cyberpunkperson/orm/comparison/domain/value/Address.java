package com.github.cyberpunkperson.orm.comparison.domain.value;

import lombok.Data;

import java.util.UUID;

@Data
public class Address {

    private UUID id;

    private String country;

    private String city;

    private String street;

    private Integer zip;

}
