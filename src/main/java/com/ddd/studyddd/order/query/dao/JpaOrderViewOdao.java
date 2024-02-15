package com.ddd.studyddd.order.query.dao;

import com.ddd.studyddd.order.query.dto.OrderView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaOrderViewOdao implements OrderViewDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<OrderView> selectByOrderer(String ordererId) {
        String selectQuery =
                "select new com.ddd.studyddd.order.query.dto.OrderView(o, m, p) " +
                "from Order o join o.orderLines ol, Member m, Product p " +
                "where o.orderder.memberId.id = :ordererId " +
                "and o.orderer.memberId = m.id " +
                "and ol.productId = p.id " +
                "order by o.number.number desc ";

        TypedQuery<OrderView> query = em.createQuery(selectQuery, OrderView.class);
        query.setParameter("ordererId", ordererId);
        return query.getResultList();
    }
}
