package com.github.cyberpunkperson.orm.comparison.domain.item;

import com.github.cyberpunkperson.orm.comparison.controller.ItemsApiDelegate;
import com.github.cyberpunkperson.orm.comparison.model.GetItemResponse;
import com.github.cyberpunkperson.orm.comparison.model.GetItemsResponse;
import com.github.cyberpunkperson.orm.comparison.model.PutItemRequest;
import com.github.cyberpunkperson.orm.comparison.model.PutItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Component
@RequiredArgsConstructor
class ItemController implements ItemsApiDelegate {

    private final ItemService itemService;

    private final ItemMapper itemMapper;


    @Override
    public ResponseEntity<GetItemsResponse> getItems() {
        return ok(new GetItemsResponse()
                .items(itemService.findAll().stream()
                        .map(item -> itemMapper.itemToItemProjection(item))
                        .collect(toList())));
    }

    @Override
    public ResponseEntity<PutItemResponse> putItem(PutItemRequest putItemRequest) {
        Item savedItem = itemService.save(itemMapper.itepProjectionToItem(putItemRequest.getPayload()));
        return ok(new PutItemResponse().payload(itemMapper.itemToItemProjection(savedItem)));
    }

    @Override
    public ResponseEntity<GetItemResponse> getItemById(UUID itemId) {
        Item foundItem = itemService.findById(itemId);
        return ok(new GetItemResponse().payload(itemMapper.itemToItemProjection(foundItem)));
    }
}
