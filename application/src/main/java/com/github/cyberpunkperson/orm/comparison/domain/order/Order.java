package com.github.cyberpunkperson.orm.comparison.domain.order;

import com.github.cyberpunkperson.orm.comparison.domain.item.Item;
import com.github.cyberpunkperson.orm.comparison.domain.value.Address;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private UUID id;

    private UUID userId;

    private Address address;

    private List<Item> items;

}
