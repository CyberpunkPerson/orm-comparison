package com.github.cyberpunkperson.orm.comparison.domain.order;

import com.github.cyberpunkperson.orm.comparison.controller.OrdersApiDelegate;
import com.github.cyberpunkperson.orm.comparison.model.GetOrderResponse;
import com.github.cyberpunkperson.orm.comparison.model.GetOrdersResponse;
import com.github.cyberpunkperson.orm.comparison.model.PutOrderRequest;
import com.github.cyberpunkperson.orm.comparison.model.PutOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Component
@RequiredArgsConstructor
class OrderController implements OrdersApiDelegate {

    private final OrderMapper orderMapper;

    private final OrderService orderService;


    @Override
    public ResponseEntity<GetOrdersResponse> getOrders() {
        return ok(new GetOrdersResponse()
                .items(orderService.findAll().stream()
                        .map(order -> orderMapper.orderToOrderProjection(order))
                        .collect(toList())));
    }

    @Override
    public ResponseEntity<GetOrderResponse> getOrderById(UUID orderId) {
        Order foundOrder = orderService.findById(orderId);
        return ok(new GetOrderResponse().payload(orderMapper.orderToOrderProjection(foundOrder)));
    }

    @Override
    public ResponseEntity<PutOrderResponse> putOrder(PutOrderRequest putOrderRequest) {
        Order savedOrder = orderService.save(orderMapper.orderProjectionToOrder(putOrderRequest.getPayload()));
        return ok(new PutOrderResponse().payload(orderMapper.orderToOrderProjection(savedOrder)));
    }
}
