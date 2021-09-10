package com.github.cyberpunkperson.orm.comparison.domain.item.repository;

import com.github.cyberpunkperson.orm.comparison.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.StreamSupport.stream;

@Repository
@RequiredArgsConstructor
class ItemJdbcRepositoryAdapter implements ItemRepository {

    private final ItemJdbcRepository itemRepository;


    @Override
    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return stream(itemRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public Optional<Item> findById(UUID itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public List<Item> findAllByOrderId(UUID orderId) {
        return itemRepository.findAllByOrderId(orderId);
    }
}
