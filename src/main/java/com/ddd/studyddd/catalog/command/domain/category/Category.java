package com.ddd.studyddd.catalog.command.domain.category;

import com.ddd.studyddd.catalog.command.domain.product.Product;

import java.util.List;
import java.util.Set;

public class Category {
    private Set<Product> products;

    public List<Product> getProducts(int page, int size) {
        List<Product> sortedProducts = sortById(products);
        return sortedProducts.subList((page-1) * size, page * size);
    }

    private List<Product> sortById(Set<Product> products){
        return products.stream().toList();
    }
}
