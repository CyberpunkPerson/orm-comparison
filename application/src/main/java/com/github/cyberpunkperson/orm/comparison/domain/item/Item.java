package com.github.cyberpunkperson.orm.comparison.domain.item;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Item {

    @Id
    private UUID id;

    private String title;

    private String description;

    private BigDecimal price;

}
