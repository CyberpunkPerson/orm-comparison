package com.github.cyberpunkperson.orm.comparison.domain.item.repository;

import com.github.cyberpunkperson.orm.comparison.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ItemJpaRepository extends ItemRepository, JpaRepository<Item, UUID> {

}
