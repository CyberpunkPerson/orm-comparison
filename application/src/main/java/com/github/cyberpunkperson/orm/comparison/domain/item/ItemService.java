package com.github.cyberpunkperson.orm.comparison.domain.item;

import com.github.cyberpunkperson.orm.comparison.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class ItemService {

    private final ItemRepository itemRepository;


    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item findById(UUID itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item with such id was not found"));
    }

}
