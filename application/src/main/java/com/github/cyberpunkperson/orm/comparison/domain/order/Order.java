package com.github.cyberpunkperson.orm.comparison.domain.order;

import com.github.cyberpunkperson.orm.comparison.model.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.UUID;

@Data
class Order {

    @Id
    private UUID id;

    private UUID userId;

    @MappedCollection(idColumn = "address_id")
    private Address address;

    @MappedCollection(idColumn = "id")
    private List<Item> items;

}