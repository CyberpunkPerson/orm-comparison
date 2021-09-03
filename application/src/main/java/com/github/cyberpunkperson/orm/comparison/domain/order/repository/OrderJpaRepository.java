package com.github.cyberpunkperson.orm.comparison.domain.order.repository;

import com.github.cyberpunkperson.orm.comparison.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface OrderJpaRepository extends OrderRepository, JpaRepository<Order, UUID> {

}
