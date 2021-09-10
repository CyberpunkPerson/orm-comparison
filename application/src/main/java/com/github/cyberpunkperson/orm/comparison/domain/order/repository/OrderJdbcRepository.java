package com.github.cyberpunkperson.orm.comparison.domain.order.repository;

import com.github.cyberpunkperson.orm.comparison.domain.order.Order;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.util.ObjectUtils.isEmpty;

interface OrderJdbcRepository extends CrudRepository<Order, UUID> {


    @Override
    @Transactional
    default Order save(Order order) {

        save(order.getId(), order.getUserId(), order.getAddress().getId());
        if (!isEmpty(order.getItems())) {
            List<UUID[]> orderItems = order.getItems().stream()
                    .map(item -> new UUID[]{order.getId(), item.getId()})
                    .toList();
            saveItems(order.getId(), orderItems);
        }
        return order;
    }

    @Query("""
            insert into orders as orders (id, user_id, address_id) 
            values (:id, :userId, :addressId) 
            on conflict (id) 
            do update 
               set address_id = excluded.address_id 
            where orders.user_id = excluded.user_id 
            returning id, user_id, address_id;
            """)
    Order save(UUID id, UUID userId, UUID addressId);

    @Modifying
    @Query("""
            with new_items (order_id, item_id) as (values :orderItems), 
            save as ( 
                insert into order_item (order_id, item_id) 
                select * from new_items 
                on conflict (order_id, item_id) do nothing)
            delete from order_item 
            where order_id = :orderId and item_id not in (select item_id from new_items);
    """)
    void saveItems(UUID orderId, List<UUID[]> orderItems);

    @Override
    @Query("""
            select 
                orders.id as id, 
                orders.user_id as user_id, 
                address.id as address_id, 
                address.zip as address_zip, 
                address.city as address_city, 
                address.street as address_street, 
                address.country as address_country 
            from orders 
                left outer join address address on address.id = orders.address_id 
            where orders.id = :orderId;
            """)
    Optional<Order> findById(UUID orderId);

    @Override
    @Query("""
            select 
                orders.id as id, 
                orders.user_id as user_id, 
                address.id as address_id, 
                address.zip as address_zip, 
                address.city as address_city, 
                address.street as address_street, 
                address.country as address_country 
            from orders orders
                left outer join address address on address.id = orders.address_id;
            """)
    List<Order> findAll();

    @Query("""
            select orders.* 
            from order_item order_item 
                left join orders orders on order_item.order_id = orders.id 
            where order_item.item_id in (:itemsId);
            """)
    List<Order> findAllByItemsIdIn(List<UUID> itemsId);

    @Query("select * from orders where address_id = :addressId")
    List<Order> findAllByAddressId(UUID addressId);
}
