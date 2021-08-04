package com.github.cyberpunkperson.orm.comparison.domain.order;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order orderProjectionToOrder(com.github.cyberpunkperson.orm.comparison.model.Order order);

    com.github.cyberpunkperson.orm.comparison.model.Order orderToOrderProjection(Order order);
}
