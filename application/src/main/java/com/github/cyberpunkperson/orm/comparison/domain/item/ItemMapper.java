package com.github.cyberpunkperson.orm.comparison.domain.item;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item itepProjectionToItem(com.github.cyberpunkperson.orm.comparison.model.Item itemProjection);

    com.github.cyberpunkperson.orm.comparison.model.Item itemToItemProjection(Item item);

}
