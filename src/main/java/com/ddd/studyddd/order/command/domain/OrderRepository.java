package com.ddd.studyddd.order.command.domain;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(OrderId id);
    void save(Order order);
    List<Order> findByOrdererId(String ordererId, int startRow, int size);

    void delete(Order order);
}
