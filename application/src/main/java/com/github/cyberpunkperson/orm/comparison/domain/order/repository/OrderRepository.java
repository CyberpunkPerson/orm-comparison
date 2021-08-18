package com.github.cyberpunkperson.orm.comparison.domain.order.repository;

import com.github.cyberpunkperson.orm.comparison.domain.order.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(UUID orderId);

//    List<Order> findAllByItems(List<UUID> itemsId); todo refactor!
//
//    List<Order> findAllByAddress(UUID addressId);  todo refactor!

}
