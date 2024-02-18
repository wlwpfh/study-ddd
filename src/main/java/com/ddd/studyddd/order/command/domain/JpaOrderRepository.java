package com.ddd.studyddd.order.command.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public Optional<Order> findById(OrderId id) {
        return Optional.ofNullable(em.find(Order.class, id));
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }
}
