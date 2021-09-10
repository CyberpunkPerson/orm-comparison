package com.github.cyberpunkperson.orm.comparison.domain.item.repository;

import com.github.cyberpunkperson.orm.comparison.domain.item.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemRepository {

    Item save(Item item);

    List<Item> findAll();

    Optional<Item> findById(UUID itemId);

    List<Item> findAllByOrderId(UUID orderId);

}
