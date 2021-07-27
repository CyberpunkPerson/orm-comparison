package com.github.cyberpunkperson.orm.comporasion.domain.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.UUID;

@Data
class User {

    @Id
    private UUID id;

    private String name;

    @MappedCollection(idColumn = "id")
    private Address address;

}
