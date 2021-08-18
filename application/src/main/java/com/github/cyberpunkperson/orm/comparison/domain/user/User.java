package com.github.cyberpunkperson.orm.comparison.domain.user;

import com.github.cyberpunkperson.orm.comparison.domain.value.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.UUID;

@Data
public class User {

    @Id
    private UUID id;

    private String name;

    @MappedCollection(idColumn = "id")
    private Address address;

}
