package com.github.cyberpunkperson.orm.comparison.domain.user;

import com.github.cyberpunkperson.orm.comparison.domain.value.Address;
import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;

    private String name;

    private Address address;

}
