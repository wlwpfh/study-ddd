package com.ddd.studyddd.catalog.command.domain.product;


import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductRepository extends Repository<Product, ProductId> {
    List<Product> findByCategoryId(Long categoryId, int page, int size);
    Integer countsByCategoryId(Long categoryId);
}
