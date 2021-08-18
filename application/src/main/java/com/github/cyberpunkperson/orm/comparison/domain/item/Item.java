package com.github.cyberpunkperson.orm.comparison.domain.item;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Item {

    private UUID id;

    private String title;

    private String description;

    private BigDecimal price;

}
