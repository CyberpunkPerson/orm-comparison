package com.github.cyberpunkperson.orm.comparison.domain.item;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Item {

    @Id
    private UUID id;

    private String title;

    private String description;

    private BigDecimal price;

}
