package com.github.cyberpunkperson.orm.comporasion.domain.order;

import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    Order orderProjectionToOrder(com.github.cyberpunkperson.orm.comporasion.model.Order order);

    com.github.cyberpunkperson.orm.comporasion.model.Order orderToOrderProjection(Order order);
}
