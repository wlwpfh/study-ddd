package com.ddd.studyddd.order.command.domain;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(OrderId id);
    void save(Order order);
}
