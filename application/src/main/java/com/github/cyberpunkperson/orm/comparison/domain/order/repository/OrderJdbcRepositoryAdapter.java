package com.github.cyberpunkperson.orm.comparison.domain.order.repository;

import com.github.cyberpunkperson.orm.comparison.domain.item.repository.ItemRepository;
import com.github.cyberpunkperson.orm.comparison.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
class OrderJdbcRepositoryAdapter implements OrderRepository {

    private final OrderJdbcRepository orderRepository;

    private final ItemRepository itemRepository;


    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return enrichOrders(orderRepository.findAll().stream());
    }

    @Override
    public Optional<Order> findById(UUID orderId) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setItems(itemRepository.findAllByOrderId(orderId));
                    return order;
                });
    }

    @Override
    public List<Order> findAllByItemsIdIn(List<UUID> itemsId) {
        return enrichOrders(orderRepository.findAllByItemsIdIn(itemsId).stream());
    }

    @Override
    public List<Order> findAllByAddressId(UUID addressId) {
        return enrichOrders(orderRepository.findAllByAddressId(addressId).stream());
    }

    private List<Order> enrichOrders(Stream<Order> orderStream) {
        return orderStream
                .peek(order -> order.setItems(itemRepository.findAllByOrderId(order.getId())))
                .toList();
    }
}
