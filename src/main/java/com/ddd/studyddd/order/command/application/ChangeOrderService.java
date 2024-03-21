package com.ddd.studyddd.order.command.application;

import com.ddd.studyddd.order.command.domain.Order;
import com.ddd.studyddd.order.command.domain.OrderId;
import com.ddd.studyddd.order.command.domain.OrderRepository;
import com.ddd.studyddd.order.command.domain.ShippingInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangeOrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void changeShippingInfo(OrderId id, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        Order order = orderOpt.orElseThrow(() -> new OrderNotFoundException());
        order.changeShippingInfo(newShippingInfo);
    }
}
