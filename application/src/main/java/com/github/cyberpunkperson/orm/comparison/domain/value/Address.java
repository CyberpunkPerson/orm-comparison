package com.github.cyberpunkperson.orm.comparison.domain.value;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Address {

    @Id
    private UUID id;

    private String country;

    private String city;

    private String street;

    private Integer zip;

}
