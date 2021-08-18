package com.github.cyberpunkperson.orm.comparison.domain.order;

import com.github.cyberpunkperson.orm.comparison.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class OrderService {

    private final OrderRepository orderRepository;


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order with such id was not found"));
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

}
