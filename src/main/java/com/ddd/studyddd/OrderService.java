package com.ddd.studyddd;

import com.ddd.studyddd.domain.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class OrderService {
    @Transactional
    public void cancelOrder(String orderId){
        Order order = findOrderById(orderId);
        if(Objects.isNull(order)){
            throw new OrderNotFoundException(orderId);
        }
        order.cancel();
    }
}
