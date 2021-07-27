package com.github.cyberpunkperson.orm.comporasion.domain.order;

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

    @MappedCollection(idColumn = "id")
    private List<Item> items;

}
