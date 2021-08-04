package com.github.cyberpunkperson.orm.comparison.domain.user.entity;

import lombok.Data;

import java.util.UUID;

@Data
class Address {

    private UUID id;

    private String country;

    private String city;

    private String street;

    private Integer zip;

}
