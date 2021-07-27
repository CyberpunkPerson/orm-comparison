package com.github.cyberpunkperson.orm.comporasion.domain.order;

import com.github.cyberpunkperson.orm.comporasion.controller.OrdersApiDelegate;
import com.github.cyberpunkperson.orm.comporasion.model.GetOrdersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Component
@RequiredArgsConstructor
public class OrderController implements OrdersApiDelegate {

    private final OrderMapper orderMapper;

    private final OrderService orderService;

    @Override
    public ResponseEntity<GetOrdersResponse> getOrders() {
        return ok(new GetOrdersResponse()
                .items(orderService.getAll().stream()
                        .map(order -> orderMapper.orderToOrderProjection(order))
                        .collect(toList())));
    }
}
