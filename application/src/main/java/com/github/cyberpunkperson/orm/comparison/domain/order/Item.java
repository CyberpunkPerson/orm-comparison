package com.github.cyberpunkperson.orm.comparison.domain.order;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
class Item {

    @Id
    private UUID id;

    private String title;

    private String description;

    private Double price;

}
