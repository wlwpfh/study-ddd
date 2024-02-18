package com.ddd.studyddd.catalog.command.domain.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaProductRepository implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findByCategoryId(Long categoryId, int page, int size) {
        TypedQuery<Product> query = em.createQuery(
    "select p from Product p " +
            "where :categoryId member of p.categoryIds order by p.id.id desc "
            , Product.class);
        query.setParameter("categoryId", categoryId);
        query.setFirstResult((page-1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public Integer countsByCategoryId(Long categoryId) {
        return null;
    }
}
