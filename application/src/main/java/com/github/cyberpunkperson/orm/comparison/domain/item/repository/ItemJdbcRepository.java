package com.github.cyberpunkperson.orm.comparison.domain.item.repository;

import com.github.cyberpunkperson.orm.comparison.domain.item.Item;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface ItemJdbcRepository extends CrudRepository<Item, UUID> {

    @Query("""
            select item.* 
            from order_item order_item 
                left outer join item item on order_item.item_id = item.id 
            where order_item.order_id = :orderId;
            """)
    List<Item> findAllByOrderId(UUID orderId);
}
