package com.ddd.studyddd.order.command.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {
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

    @Override
    public List<Order> findByOrdererId(String ordererId, int startRow, int fetchSize) {
        TypedQuery<Order> query = em.createQuery(
                "select o from Order o " +
                        "where o.orderer.memberId.id = :ordererId " +
                        "order by o.number.number desc"
                , Order.class);
        query.setParameter("ordererId", ordererId);
        query.setFirstResult(startRow);
        query.setMaxResults(fetchSize);
        return query.getResultList();
    }

    @Override
    public void delete(Order order) {
        em.remove(order);
    }
}
