package com.github.cyberpunkperson.orm.comparison.domain.order;

import com.github.cyberpunkperson.orm.comparison.domain.item.Item;
import com.github.cyberpunkperson.orm.comparison.domain.value.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class Order {

    @Id
    private UUID id;

    private UUID userId;

    private Address address;

    @Transient
    private List<Item> items;

}
