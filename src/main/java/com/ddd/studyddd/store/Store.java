package com.ddd.studyddd.store;

import com.ddd.studyddd.catalog.command.domain.product.Product;
import com.ddd.studyddd.catalog.command.domain.product.ProductId;

public class Store {
    public Product createProduct(ProductId newProductId){
        if(isBlocked()){
            throw new StoreBlockedException();
        }
        return new Product(newProductId);
    }
}
